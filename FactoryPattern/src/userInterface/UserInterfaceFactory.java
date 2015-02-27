package userInterface;

public class UserInterfaceFactory {
	
	FileType type = null;
	
	public static IStorage makeUser(FileType type){
		
		IStorage storage = null;
		
		if(type==FileType.ARRAYLIST){
			storage = new StoreToList();
		}
		if(type==FileType.FILE){
			storage = new StoreToFile();
		}
		
		return storage;
	}

}
