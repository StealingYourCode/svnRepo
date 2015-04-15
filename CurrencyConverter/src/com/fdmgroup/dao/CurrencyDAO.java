package com.fdmgroup.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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

}
