package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import controllers.LoginController;
import dao.UserDAO;
import dto.UserDTO;

public class LoginControllerTest {

	private LoginController lc;
	private Collection<UserDTO> users;
	private UserDAO dao;
	private UserDTO user1, user2, user3;

	@Before
	public void setUp(){

		lc = new LoginController();
		users = new ArrayList<UserDTO>();
		user1 = new UserDTO("Bobsaget", "password", "fullhouse@gmail.com");
		user2 = new UserDTO("person2", "password2", "myemail@aol.com");
		user3 = new UserDTO("Andersonsilva", "belch", "spider@gmail.com");
		
		

	}

	@Test
	public void TestUsernameMatchReturnsTrue() {

		UserDTO returnUser = dao.read(user1);
		assertTrue(returnUser.equals(user1));
	}
}
