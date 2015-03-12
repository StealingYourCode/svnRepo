package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import jpa.User_DAO_JPA;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dto.UserDTO;
import exceptions.NoUserException;
import exceptions.StorableNotFoundException;

public class UserJPA_DAO_test {
	
	User_DAO_JPA dao = new User_DAO_JPA();
	UserDTO user1, user2, blankuser;

	@Before
	public void setup(){
		user1 = new UserDTO(21, "jpalouis", "password", "louis", "yang");
		user2 = new UserDTO(22, "FHLH", "woooooo","Foghorn","Leghorn");
			
		
	}
	
//	@Test
//	public void testCreate() throws StorableNotFoundException{
//		dao.create(user1);
//	}
	
//	@Test
//	public void testReadIntParam(){
//		try {
//			UserDTO result = dao.read(10);
//			assertTrue(result.getFirstname().equals("Elliot"));
//		} catch (NoUserException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testReadStringParam(){
//		UserDTO result;
//		try {
//			result = dao.read("JAN");
//			assertTrue(result.getFirstname().equals("Janet"));
//		} catch (NoUserException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	@Test
//	(expected=NoUserException.class)
//	public void testCreateThrowsCorrectException() throws NoUserException{
//		dao.create(blankuser);
//	}
	
//	@Test
//	(expected=NoUserException.class)
//	public void testReadThrowsException() throws NoUserException{
//		UserDTO result = dao.read("JN");
//		assertTrue(result.getFirstname().equals("Janet"));
//	}
	
//	@Test
//	public void testDelete() throws StorableNotFoundException{
//		try {
//			dao.delete(21);
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	(expected=StorableNotFoundException.class)
//	public void testDeleteThrowsException() throws StorableNotFoundException{
//		try {
//			dao.delete(100);
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void testUpdate() throws StorableNotFoundException{
		dao.update(user1, user2);
	}
	
//	@Test
//	(expected=StorableNotFoundException.class)
//	public void testUpdateThrowsNoUserException() throws StorableNotFoundException{
//		dao.update(null, user1);
//	}

}
