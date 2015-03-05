package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import userManager.UserActions;
import exceptions.NoUserException;
import exceptions.UsernamePasswordMismatchException;
import controllers.LoginController;
import dao.IStorage;
import dao.UserDAO;
import db.UserList;
import dto.IStorable;
import dto.UserDTO;

public class LoginControllerTest {

	private LoginController lc;
	private UserDAO dao;
	private UserActions ua = new UserActions();;
//	private Collection<UserDTO> userList;
	@Mock UserDTO user1, user2, user3;

	@Before
	public void setUp(){

		lc = new LoginController();
		dao = new UserDAO();
		
//		userList = new ArrayList<UserDTO>();
		MockitoAnnotations.initMocks(this);

//		user1 = new UserDTO("Bobsaget", "password", "fullhouse@gmail.com");
//		user2 = new UserDTO("person2", "password2", "myemail@aol.com");
//		user3 = new UserDTO("Andersonsilva", "hespect", "spider@gmail.com");
//		
		when(user1.getUsername()).thenReturn("Bobsaget");
		when(user1.getPassword()).thenReturn("Password");
		
		when(user2.getUsername()).thenReturn("person2");
		when(user2.getPassword()).thenReturn("password2");
		
		
//		UserList.getUserList().add(user1);
		dao.create(user1);
		dao.create(user2);
//		dao.create(user2);
//		dao.create(user3);
		
		
		
	}

	@Test
	public void TestUsernameMatchReturnsTrue() throws NoUserException {

		UserDTO returnUser=null;
		returnUser = dao.read("Bobsaget");
		assertTrue(returnUser.equals(user1));
	}
//	
	@Test
	public void TestLoginController_Login() throws NoUserException{
		
//		lc.doCommand();
		ua.Login("Bobsaget", "Password");
//		assertTrue(returnuser.getPassword().equals(user1.getPassword()));
//		System.out.println(user1);
//		System.out.println(ua.Login("Bobsaget", "Password"));
//		System.out.println(returnuser);
	}
	
	
	@Test
//	(expected = NoUserException.class)
	public void TestNoUserException() throws NoUserException{
		dao.read(null);
	}
	
	@Test (expected = NoUserException.class)
	public void TestUsernamePasswordMismatchException() throws NoUserException {
		
			ua.Login("Bobsaget", "Psword");
	}
	
//	@Test
//	public void TestUpdateMethod(){
//		dao.update(user1, user2);
//		assertTrue(.equals("person2"));
//	}
//	
//	@Test
//	public void TestLoginLogger() throws UsernamePasswordMismatchException{
//		lc.doCommand();
//	}
	
//	@Test
//	(expected = NoUserException.class)
//	public void TestLoginLoggerExceptions() {
//		lc.doCommand();
//	}
	
	
}
