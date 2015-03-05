package commands;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import userManager.UserActions;
import dto.UserDTO;
import exceptions.InvalidInputException;
import exceptions.NoUserException;
import exceptions.UsernamePasswordMismatchException;
import interfaces.ICommand;

public class LoginCommand implements ICommand{
	
	UserDTO temp;
	UserDTO potentialUser;
	UserActions useractions = new UserActions();

	@Override
	public void execute() {
	
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a username");
		String username = scanner.nextLine();
		System.out.println("Enter your password");
		String password = scanner.nextLine();
		
		
		
		try {
			useractions.Login(username, password);
		} catch (NoUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

		
//		try {
//			useractions.Login(username, password);
//			throw new UsernamePasswordMismatchException("Username and password do not match.");
//		} catch (NoUserException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UsernamePasswordMismatchException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	
		
		
	}
	
	static Logger log = 
			Logger.getLogger(InvalidInputException.class);

}
