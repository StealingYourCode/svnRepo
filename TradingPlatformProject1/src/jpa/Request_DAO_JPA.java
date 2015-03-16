package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import dao.IStorage;
import dto.IStorable;
import dto.RequestDTO;
import dto.UserDTO;
import exceptions.NoUserException;
import exceptions.StorableNotFoundException;

public class Request_DAO_JPA implements IStorage<RequestDTO, Integer, Integer>{

	@Override
	public IStorable create(RequestDTO request) throws StorableNotFoundException {
		// TODO Auto-generated method stub
				if(request==null)
					throw new StorableNotFoundException("This request does not exist");

				
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
		RequestDTO result = em.find(RequestDTO.class, id);
		
		em.close();
		emf.close();
		return result;
		
		}catch (NoResultException e){
			e.printStackTrace();
			throw new StorableNotFoundException("This request does not exist");
			
		}
	}

	@Override
	public void update(RequestDTO oldrequest, RequestDTO newrequest)
			throws StorableNotFoundException {
		if(oldrequest == null || newrequest == null)
			throw new StorableNotFoundException("This request does not exist");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		RequestDTO result = em.find(RequestDTO.class, oldrequest.getRequest_id());
		
		em.getTransaction().begin();
		
		em.getTransaction().commit();
		
		result.setBuy_or_sell(newrequest.getBuy_or_sell());
		result.setLimit_price(newrequest.getLimit_price());
		result.setMinimum_shares(newrequest.getMinimum_shares());
		result.setParent_request_id(newrequest.getParent_request_id());
		result.setRequest_date(newrequest.getRequest_date());
		result.setShareholder_id(newrequest.getShareholder_id());
		result.setShares(newrequest.getShares());
		result.setShares_filled(newrequest.getShares_filled());
		result.setStock_id(newrequest.getStock_id());
		result.setStop_price(newrequest.getStop_price());
		result.setTime_in_force(newrequest.getTime_in_force());
		
		em.close();
		emf.close();
		
	}

	@Override
	public void delete(Integer id) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		Request_DAO_JPA dao = new Request_DAO_JPA();
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		if(em.find(RequestDTO.class, id)==null)
			throw new StorableNotFoundException("This request does not exist");
		
		em.getTransaction().begin();
		em.remove(em.find(RequestDTO.class, id));
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
