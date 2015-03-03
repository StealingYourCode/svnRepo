package dto;


public class UserDTO implements IStorable {
	
	private String username;
	private String password;
	static int userID=1000;
	private String email;
	
	public UserDTO(String username, String password, String email){
		this.username=username;
		this.password=password;
		this.email=email;
		
	}
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}