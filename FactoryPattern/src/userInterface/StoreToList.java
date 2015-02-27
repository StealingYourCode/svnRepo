package userInterface;

import java.util.ArrayList;
import java.util.Random;

public class StoreToList implements IStorage {

	/**
	 * DAO data access object. 
	 */
	ArrayList<User> userList = new ArrayList<User>();
	
	Random rand = new Random();
	int rand_num=rand.nextInt(9999)+1;
	
	@Override
	public User createUser(User user, int id) {
		userList.add(user);
		user.setUserID(id);
		System.out.println("User has been created with ID: " +user.getUserID());
		return user;
	}

	@Override
	public void readUser(User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getUserID());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		
	}

	@Override
	public void updateUser(User user, String username, String password, String email) {
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
	}

	@Override
	public void deleteUser(User user) {
		System.out.println(user.getUsername()+" was deleted");
		userList.remove(user);
	}
	
	public User searchUser(int UserID){
		User user=null;
		for(int i=0;i<userList.size();i++){
			
			
			if (userList.get(i).getUserID()==UserID)
				user=userList.get(i);
				
		}
		return user;
	}

}
