package controllers;

import commands.LoginCommand;

import interfaces.ICommand;
import exceptions.NoUserException;
import dao.UserDAO;
import db.UserList;
import dto.UserDTO;

public class LoginController {
	
	
	private ICommand command1;
	private LoginCommand logincommand = new LoginCommand();
	
	public void doCommand(){
		 logincommand.execute();
	}
}
