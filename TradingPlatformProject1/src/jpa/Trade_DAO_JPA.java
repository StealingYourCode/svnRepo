package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import dao.IStorage;
import dto.IStorable;
import dto.RequestDTO;
import dto.TradeDTO;
import exceptions.StorableNotFoundException;

public class Trade_DAO_JPA implements IStorage<TradeDTO, Integer, Integer> {
	
	
	@Override
	public IStorable create(TradeDTO request) throws StorableNotFoundException {
		// TODO Auto-generated method stub
				if(request==null)
					throw new StorableNotFoundException("This trade does not exist");

				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

				EntityManager em = emf.createEntityManager();
				
				em.getTransaction().begin();
				em.persist(request);
				em.getTransaction().commit();
				
				
				em.close();
				emf.close();
				return request;
	}

	@Override
	public IStorable read(Integer id) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		try{
			TradeDTO result = em.find(TradeDTO.class, id);
		
		em.close();
		emf.close();
		return result;
		
		}catch (NoResultException e){
			e.printStackTrace();
			throw new StorableNotFoundException("This request does not exist");
			
		}
	}

	@Override
	public void update(TradeDTO oldtrade, TradeDTO newtrade)
			throws StorableNotFoundException {
		if(oldtrade == null || newtrade == null)
			throw new StorableNotFoundException("This request does not exist");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		TradeDTO result = em.find(TradeDTO.class, oldtrade.getTrade_id());
		
		em.getTransaction().begin();
		
		em.getTransaction().commit();
		
		result.setBuy_request_id(newtrade.getBuy_request_id());
		result.setBuyer_id(newtrade.getBuyer_id());
		result.setPrice_total(newtrade.getPrice_total());
		result.setSell_request_id(newtrade.getSell_request_id());
		result.setSeller_id(newtrade.getSeller_id());
		result.setShare_price(newtrade.getShare_price());
		result.setShares(newtrade.getShares());
		result.setStock_id(newtrade.getStock_id());
		result.setTrade_id(newtrade.getTrade_id());
		result.setTransaction_time(newtrade.getTransaction_time());
		
		
		em.close();
		emf.close();
		
	}

	@Override
	public void delete(Integer id) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		Trade_DAO_JPA dao = new Trade_DAO_JPA();
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		if(em.find(TradeDTO.class, id)==null)
			throw new StorableNotFoundException("This trade does not exist");
		
		em.getTransaction().begin();
		em.remove(em.find(TradeDTO.class, id));
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
