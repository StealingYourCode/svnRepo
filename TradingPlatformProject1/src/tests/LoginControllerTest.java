package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import controllers.LoginController;
import dao.UserDAO;
import db.UserList;
import dto.IStorable;
import dto.UserDTO;

public class LoginControllerTest {

	private LoginController lc;
	private UserDAO dao;
	private UserDTO user1, user2, user3;

	@Before
	public void setUp(){

		lc = new LoginController();
		user1 = new UserDTO("Bobsaget", "password", "fullhouse@gmail.com");
		user2 = new UserDTO("person2", "password2", "myemail@aol.com");
		user3 = new UserDTO("Andersonsilva", "belch", "spider@gmail.com");
		
		UserList.getUserList().add(user1);
		UserList.getUserList().add(user2);
		UserList.getUserList().add(user3);
		
		dao = new UserDAO();
		

		
	}

	@Test
	public void TestUsernameMatchReturnsTrue() {

		UserDTO returnUser=null;
		returnUser = dao.read(user1);
		assertTrue(returnUser.equals(user1));
	}
	
	@Test
	public void TestLoginController_Login(){
		UserDTO returnUser=null;
		returnUser = lc.Login("Bobsaget", "password");
		assertFalse(returnUser.equals(user1));
		System.out.println(returnUser);
		System.out.println(user1);
	}
}
