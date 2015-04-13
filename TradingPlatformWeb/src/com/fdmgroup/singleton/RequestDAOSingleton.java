package com.fdmgroup.singleton;

import jpa.Request_DAO_JPA;

public class RequestDAOSingleton {
	
	private static Request_DAO_JPA instance = null;
	
	protected RequestDAOSingleton(){
		
	}
	
	public static Request_DAO_JPA getInstance(){
		if(instance == null)
			instance = new Request_DAO_JPA();
		
		return instance;
	}

}
