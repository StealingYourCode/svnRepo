package db;

import java.util.ArrayList;

import dto.UserDTO;

public class UserList {
	
	private ArrayList<UserDTO> userList = new ArrayList<UserDTO>();

	public ArrayList<UserDTO> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<UserDTO> userList) {
		this.userList = userList;
	}


}
