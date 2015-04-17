package com.fdmgroup.singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFSingleton {

	private static EntityManagerFactory instance = null;
	
	private EMFSingleton(){
		
	}
	
	public static EntityManagerFactory getInstance(){
		if(instance==null){
			 instance = Persistence.createEntityManagerFactory("TradingPlatformWeb");
		}
		
		return instance;
	}
}
