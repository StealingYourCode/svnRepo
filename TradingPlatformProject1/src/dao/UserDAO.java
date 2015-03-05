package dao;

import java.util.ArrayList;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import userManager.UserActions;
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
	public UserDTO create(UserDTO user) {
		PropertyConfigurator.configure("log4j.properties");
		log.info(user + " has been created");
		userList.add(user);
		return user;
	}

	@Override
	public UserDTO read(String username) throws NoUserException{
		
		for (UserDTO user : userList) {
			if (user.getUsername().equals(username))
				return user;
		}
		throw new NoUserException("User Not found");
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
	public void delete(String username) throws NoUserException {
		// TODO Auto-generated method stub
		UserDAO userdao = new UserDAO();
		
		if(userdao.read(username)==null)
			throw new NoUserException("This user does not exist");
			
			
		for(UserDTO user : userList){
			if(user.getUsername().equals(username)){
				
				userList.remove(user);
				PropertyConfigurator.configure("log4j.properties");
				log.info(user + " has been deleted");
			}
		}
//		PropertyConfigurator.configure("log4j.properties");
		
		
	}
	static Logger log = Logger.getLogger(UserDAO.class);

}