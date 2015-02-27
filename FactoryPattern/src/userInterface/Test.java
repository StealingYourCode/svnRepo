package userInterface;

public class Test {

	public static void main(String[] args) {

		StoreToList cu=new StoreToList();
		
		cu.createUser(new User("jack","12345","jack@gmail.com"), 1);
		System.out.println(cu.userList.get(0));
		cu.readUser(cu.userList.get(0));
		cu.updateUser(cu.userList.get(0), "Bob", "burgers", "bob@aol.com");
		cu.readUser(cu.searchUser(cu.userList.get(0).getUserID()));
		cu.deleteUser(cu.userList.get(0));
		
//		UserInterfaceFactory.makeUser(FileType.ARRAYLIST).createUser();
		//		UserInterfaceFactory.makeUser().updateUser(, username, password, email);
		
		/**
		 * Istorage Storage = UserInterfaceFactory.makeUser();
		 */
	}

}
