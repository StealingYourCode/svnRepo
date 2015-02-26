package login;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


public class LoginAuthenticatorTest {
	
	
	private LoginAuthenticator authenticator;
	private Collection<User> users;
	@Mock private User user1,user2,user3;

	@Before
	public void setUp() throws Exception {
		authenticator = new LoginAuthenticator();
		 users= new ArrayList<User>();
		 
		 MockitoAnnotations.initMocks(this);
		
//		 user1 = mock(User.class);
		 when(user1.getPassword()).thenReturn("Yang");
		 when(user1.getUsername()).thenReturn("Louis");
		 
//		 user2 = mock(User.class);
		 when(user2.getPassword()).thenReturn("firstname");
		 when(user2.getPassword()).thenReturn("LastNAme");
		 
//		 user3 = mock(User.class);
		 when(user3.getPassword()).thenReturn("Some");
		 when(user3.getPassword()).thenReturn("Girl");
		 
		 users.add(user1);
		 users.add(user2);
		 users.add(user3);
		
	}

	@Test
	public void testUsernameMatch_ReturnTrue() {
	
		assertTrue(authenticator.usernameMatch(users, "Louis"));
	}
	
//	@Test
//	public void testUsernameMatch_ReturnFalse() {
//		
//		assertFalse(authenticator.usernameMatch(users, "Mfeafe"));
//	}
	
	@Test 
	public void testUsernameMatch_ReturnsFalse_WhenCollectionIsNull(){
		assertFalse(authenticator.usernameMatch(null, "Louis"));
	}
	
	@Test
	public void testUsernameMatch_returnsFalse_whenCollectionHasNoUsers(){
		assertFalse(authenticator.usernameMatch(new ArrayList<User>(), "Louis" ));
	}
	
	@Test
	public void testUsernameMatch_returnsCorrectUser() throws NoUserException {
		User resultUser = authenticator.returnMatchUser(users, "Louis", "Yang");
		assertTrue(resultUser.getUsername().equals("Louis"));
		assertTrue(resultUser.getPassword().equals("Yang"));
	}
	
	@Test
	public void testReturnMatchser_ThrowsNoUserException_WhenUserDoesntExist(){
		try{
		authenticator.returnMatchUser(users, "blah", "blah");
		assertFalse(false);
		} catch (NoUserException e ){
			assertTrue(true);
		}
	}
	
	@Test(expected=NoUserException.class)
	public void testReturnMatchser_ThrowsNoUserException_WhenUserDoesntExist2() throws NoUserException{
		
		authenticator.returnMatchUser(users, "blah", "blah");
		
	}
	
	@Test
	public void testLogUserActivity_callsCorrectMethod(){
		authenticator.logUserActivity(user1, "Extra string");
		verify(user1, times(1)).displayDetails("Extra string");
		
	}
	
	@Test
	public void testLogUserActivity_falsWithWrongMessage(){
		authenticator.logUserActivity(user1, "Extra string");
		verify(user1, times(0)).displayDetails("Extra");
		
	}

	
	
	

}
