package dao;

import java.util.ArrayList;
import java.util.Collection;

import controllers.LoginController;
import dto.UserDTO;

public class Test {
	public static void main(String[] args) {
		LoginController lc;
		Collection<UserDTO> users;
		UserDAO dao;
		UserDTO user1, user2, user3;
		
		lc = new LoginController();
		users = new ArrayList<UserDTO>();
		user1 = new UserDTO("Bobsaget", "password", "fullhouse@gmail.com");
		user2 = new UserDTO("person2", "password2", "myemail@aol.com");
		user3 = new UserDTO("Andersonsilva", "belch", "spider@gmail.com");
		
	}

}
