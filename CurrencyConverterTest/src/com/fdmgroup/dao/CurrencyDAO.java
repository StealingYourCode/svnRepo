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
		
//		for(Currency currency: currencyList){
			em.persist(currency);
//		}
		
		em.getTransaction().commit();

//		return currencyList;
		return currency;

	}
	
	
	public ArrayList<Currency> create(ArrayList<Currency> currencyList){
		EntityManagerFactory emf = EMFSingleton.getInstance();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		for(Currency currency: currencyList){
			em.persist(currency);
		}
		
		em.getTransaction().commit();

		return currencyList;
//		return currency;
	}
	
	public Currency read(String name){
		EntityManagerFactory emf = EMFSingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createNativeQuery("SELECT * FROM CURRENCY WHERE CURRENCYNAME =  '"+name+"' AND currencyDate ='14-APR-2015'", Currency.class);
		Currency result = (Currency) query.getSingleResult();
		return result;
		
	}
	
	public Double avgCurrency(String name){
		EntityManagerFactory emf = EMFSingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT AVG(e.rate) FROM Currency e WHERE e.currencyName = :name");
		Double result = (Double) query.getSingleResult();
		return result;
	}

}
