package dao;

import java.util.ArrayList;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import userManager.UserActions;
import db.UserList;
import dto.IStorable;
import dto.UserDTO;
import exceptions.NoUserException;
import exceptions.UsernamePasswordMismatchException;

public class UserDAO implements IStorage<UserDTO, String, Integer> {

	/**
	 * DAO data access object.
	 */

	// UserList userList = new UserList();

//	Random rand = new Random();
//	int rand_num = rand.nextInt(9999) + 1;

	static ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
	
	@Override
	public IStorable create(UserDTO user) {
		PropertyConfigurator.configure("log4j.properties");
		log.info(user + " has been created");
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
			if(userList.get(i).equals(user)){
				PropertyConfigurator.configure("log4j.properties");
				log.info(user + " has been updated");
			userList.set(i, newuser);
			}
		}
	}


	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		
		for(UserDTO user : userList){
			if(user.getUsername().equals(username)){
				PropertyConfigurator.configure("log4j.properties");
				log.info(user + " has been deleted");
				userList.remove(user);
			}
		}
//		PropertyConfigurator.configure("log4j.properties");
		log.info("This username was not found");
		
	}
	static Logger log = Logger.getLogger(UserDAO.class);

}