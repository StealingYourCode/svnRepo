package com.fdmgroup.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.fdmgroup.dto.Currency;
import com.fdmgroup.singleton.EMFSingleton;

public class CurrencyDAO {

	public Currency create(Currency currency) {
		EntityManagerFactory emf = EMFSingleton.getInstance();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
//		for (int i=0; i<currencyList.size();i++) {
			em.persist(currency);
//		}
		
		em.getTransaction().commit();

		return currency;

	}
	
	public Currency read(String name){
		EntityManagerFactory emf = EMFSingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createNativeQuery("SELECT * FROM CURRENCY WHERE CURRENCYNAME =  '"+name+"'", Currency.class);
		Currency result = (Currency) query.getSingleResult();
		return result;
		
	}

}
