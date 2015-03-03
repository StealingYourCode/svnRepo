package controllers;

import dao.UserDAO;
import db.UserList;
import dto.IStorable;
import dto.UserDTO;

public class LoginController {
	
	UserDAO userdao = new UserDAO();
	UserList ul = new UserList();
	
	public IStorable Login(String username, String password){
		if(ul.getUserList().contains(username)){
			
			for(UserDTO user: ul.getUserList()){
				if(user.getUsername().equals(username)){
					if(user.getPassword().endsWith(password))
						return user;
				}
			}
		}
		return null;
	}

}
