package com.fdmgroup.factory;

import dao.IStorage;
import dao.RequestDAO;
import dao.TradeDAO;
import dao.UserDAO;

public class DAOFactory {
	
	public enum daoType{
		USERDAO, REQUESTDAO, TRADEDAO;	
		}
	
	public static IStorage daoFactory(daoType input){
		IStorage dao = null;
		if(input == daoType.USERDAO){
			dao = new UserDAO();
		}
		if(input == daoType.REQUESTDAO){
			dao = new RequestDAO();
		}
		if(input == daoType.TRADEDAO){
			dao = new TradeDAO();
		}
		
		return dao;
		
	}

}


