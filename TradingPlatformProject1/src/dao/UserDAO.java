package dao;

import java.util.ArrayList;
import java.util.Random;

import db.UserList;
import dto.IStorable;
import dto.UserDTO;
import exceptions.NoUserException;
import exceptions.UsernamePasswordMismatchException;

public class UserDAO implements IStorage<UserDTO, String> {

	/**
	 * DAO data access object.
	 */

	// UserList userList = new UserList();

//	Random rand = new Random();
//	int rand_num = rand.nextInt(9999) + 1;

	static ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
	
	@Override
	public IStorable create(UserDTO user) {
		userList.add(user);
		return user;
	}

	@Override
	public UserDTO read(String username){
		for (UserDTO user : userList) {

			if (user.getUsername().equals(username))
				return user;

		}
		return null;
	}

	@Override
	public void update(UserDTO user, UserDTO newuser) {
		for (int i = 0; i < userList.size(); i++) {
			if(userList.get(i).equals(user));
			userList.set(i, newuser);
		}
	}

	@Override
	public void delete(UserDTO user) {
		System.out.println(user.getUsername() + " was deleted");
		userList.remove(user);
	}

	public UserDTO searchUser(int UserID) {
		UserDTO user = null;
		for (int i = 0; i < userList.size(); i++) {

			if (userList.get(i).getUserID() == UserID)
				user = userList.get(i);
		}
		return user;
	}

}