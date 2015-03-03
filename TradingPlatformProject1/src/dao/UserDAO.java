package dao;

import java.util.ArrayList;
import java.util.Random;

import db.UserList;
import dto.IStorable;
import dto.UserDTO;

public class UserDAO implements IStorage<UserDTO> {

	/**
	 * DAO data access object.
	 */

//	UserList userList = new UserList();

	Random rand = new Random();
	int rand_num = rand.nextInt(9999) + 1;

	@Override
	public IStorable create(UserDTO user, int id) {
		UserList.getUserList().add(user);
		user.setUserID(id);
		System.out
				.println("User has been created with ID: " + user.getUserID());
		return user;
	}

	@Override
	public UserDTO read(UserDTO input) {
		for (UserDTO user : UserList.getUserList()) {
			if (user.equals(input))
				return user;
		}
		return null;
	}

	@Override
	public void update(UserDTO user, UserDTO newuser) {
		for (int i = 0; i < UserList.getUserList().size(); i++) {
			UserList.getUserList().set(i, newuser);
		}
	}

	@Override
	public void delete(UserDTO user) {
		System.out.println(user.getUsername() + " was deleted");
		UserList.getUserList().remove(user);
	}

	public UserDTO searchUser(int UserID) {
		UserDTO user = null;
		for (int i = 0; i < UserList.getUserList().size(); i++) {

			if (UserList.getUserList().get(i).getUserID() == UserID)
				user = UserList.getUserList().get(i);
		}
		return user;
	}

}