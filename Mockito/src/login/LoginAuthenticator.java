package login;

import java.util.Collection;

public class LoginAuthenticator {
	
	public LoginAuthenticator(){
		
	}
	
	public boolean usernameMatch(Collection<User> users, String username){
		
		if (users != null)
			for(User user: users)
				if(user.getUsername().equals(username))
					return true;
			return false;	
	
	}
	
	public User returnMatchUser(Collection<User> users, String username, String password) throws NoUserException{
		
		if (users != null)
			for(User user : users)
				if(user.getUsername().equals(username) && user.getPassword().equals(password))
					return user;
		
		throw new NoUserException("No user exists with username: "+username+" and password: "+password);
	}
	
	public void logUserActivity(User user, String extra){
		user.displayDetails(extra);
	}

}
