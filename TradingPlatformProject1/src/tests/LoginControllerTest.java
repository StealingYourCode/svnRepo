package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import userManager.UserActions;
import exceptions.NoUserException;
import exceptions.UsernamePasswordMismatchException;
import controllers.LoginController;
import dao.IStorage;
import dao.UserDAO;
import dto.IStorable;
import dto.UserDTO;

public class LoginControllerTest {

	private LoginController lc;
	private UserDAO dao;
	private UserActions ua = new UserActions();;
	@Mock UserDTO user1, user2, user3;

	@Before
	public void setUp(){

		lc = new LoginController();
		dao = new UserDAO();
		
		MockitoAnnotations.initMocks(this);

		when(user1.getUsername()).thenReturn("Bobsaget");
		when(user1.getPassword()).thenReturn("Password");
		
		when(user2.getUsername()).thenReturn("person2");
		when(user2.getPassword()).thenReturn("password2");
		
		
		dao.create(user1);
		dao.create(user2);

		
	}

	@Test
	public void TestLoginController_Login() throws NoUserException{
		
		UserDTO returnuser1 = ua.Login("person2", "password2");
		assertTrue(returnuser1.equals(user2));
		
	}
	
	@Test
	public void TestUsernameMatchReturnsTrue() throws NoUserException {

		UserDTO returnUser=null;
		returnUser = dao.read("Bobsaget");
		assertTrue(returnUser.equals(user1));
	}
	
	
	@Test
	(expected = NoUserException.class)
	public void TestNoUserException() throws NoUserException{
		UserDTO returnuser = dao.read(null);
		assertTrue(returnuser.equals(null));
	}
	
	@Test (expected = NoUserException.class)
	public void TestUsernamePasswordMismatchException() throws NoUserException {
		
			ua.Login("Bobsaget", "Psword");
	}
	
	
//	@Test (expected = NoUserException.class)
//	public void TestLoginLoggerExceptions() {
//		lc.doCommand();
//	}
	
	
}
