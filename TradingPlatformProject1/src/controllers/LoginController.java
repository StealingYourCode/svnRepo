package controllers;

import db.UserList;
import dto.UserDTO;

public class LoginController {
	
//	UserDAO userdao = new UserDAO();
	
	public UserDTO Login(String username, String password){
		
			
			for(UserDTO user: UserList.getUserList()){
				if(user.getUsername().equals(username)){
					if(user.getPassword().equals(password))
						return user;
				}
			}
		return null;
	}

}
