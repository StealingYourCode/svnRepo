package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import userManager.UserActions;
import controllers.LoginController;
import dao.UserDAO;
import dto.UserDTO;
import exceptions.NoUserException;

public class LoginControllerTest {

	private LoginController lc;
//	private UserDAO dao;
	private UserActions ua = new UserActions();;
	@Mock UserDTO user1, user2, user3;
	@Mock UserDAO dao;

	@Before
	public void setUp(){

		lc = new LoginController();
//		dao = new UserDAO();
		
		MockitoAnnotations.initMocks(this);
		
		dao.create(user1);
		dao.create(user2);

		when(user1.getUsername()).thenReturn("Bobsaget");
		when(user1.getPassword()).thenReturn("Password");
		
		when(user2.getUsername()).thenReturn("person2");
		when(user2.getPassword()).thenReturn("password2");
		
		
		

		
	}

	@Test
	public void TestLoginController_Login() throws NoUserException{
		
		UserDTO returnuser1 = ua.Login("Bobsaget", "Password");
		assertEquals(user1, returnuser1);
		
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
//	public void TestLoginLoggerCatchesExceptions() {
//		lc.doCommand();
//	}
	
//	@Test 
//	public void TestLoginControllerSuccessful() {
//		lc.doCommand();
//	}
	
	
}
