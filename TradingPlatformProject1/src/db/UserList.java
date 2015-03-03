package db;

import java.util.ArrayList;

import dto.UserDTO;

public class UserList {
	
	private static ArrayList<UserDTO> userList = new ArrayList<UserDTO>();

	public static ArrayList<UserDTO> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<UserDTO> userList) {
		this.userList = userList;
	}


}
