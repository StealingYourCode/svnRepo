package userInterface;

public interface IStorage {
	
	public User createUser(User user, int id);
	
	public void readUser(User user);
	
	public void updateUser(User user, String username, String password, String email);
	
	public void deleteUser(User user);
	

}
