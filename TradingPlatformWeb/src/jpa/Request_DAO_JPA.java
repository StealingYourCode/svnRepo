package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.IStorage;
import dto.IStorable;
import entities.Request;
import exceptions.NoUserException;
import exceptions.StorableNotFoundException;

public class Request_DAO_JPA implements IStorage<Request, Integer, Integer> {

	@Override
	public IStorable create(Request request) throws StorableNotFoundException {
		if (request == null)
			throw new StorableNotFoundException("This request does not exist");

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("TradingPlatformWeb");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(request);
		em.getTransaction().commit();

		em.close();
		emf.close();
		return request;
	}

	@Override
	public Request read(Integer id) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("TradingPlatformWeb");

		EntityManager em = emf.createEntityManager();

		try {
			Request result = em.find(Request.class, id);

			em.close();
			emf.close();
			return result;

		} catch (NoResultException e) {
			e.printStackTrace();
			throw new StorableNotFoundException("This request does not exist");
		}
	}

	@Override
	public void update(Request oldrequest, Request newrequest)
			throws StorableNotFoundException {
		if (oldrequest == null || newrequest == null)
			throw new StorableNotFoundException("This request does not exist");

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("TradingPlatformWeb");

		EntityManager em = emf.createEntityManager();

		Request result = em.find(Request.class, oldrequest.getRequestId());

		em.getTransaction().begin();
		updateResultObj(result,newrequest);
		em.getTransaction().commit();

		emf.close();
	}

	private void updateResultObj(Request managedRequest, Request newrequest){
		managedRequest.setBuySell(newrequest.getBuySell());
		managedRequest.setLimitPrice(newrequest.getLimitPrice());
		managedRequest.setMinimumShares(newrequest.getMinimumShares());
		managedRequest.setRequestDate(newrequest.getRequestDate());
		managedRequest.setPerson(newrequest.getPerson());
		managedRequest.setShares(newrequest.getShares());
		managedRequest.setSharesFilled(newrequest.getSharesFilled());
		managedRequest.setStockId(newrequest.getStockId());
		managedRequest.setStopPrice(newrequest.getStopPrice());
		managedRequest.setTimeInForce(newrequest.getTimeInForce());
		managedRequest.setStatus(newrequest.getStatus());
	}
	
	@Override
	public void delete(Integer id) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		Request_DAO_JPA dao = new Request_DAO_JPA();

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("TradingPlatformWeb");

		EntityManager em = emf.createEntityManager();

		if (em.find(Request.class, id) == null)
			throw new StorableNotFoundException("This request does not exist");

		em.getTransaction().begin();
		em.remove(em.find(Request.class, id));
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	public ArrayList<Request> readByUserId(Integer id) {
		List<Request> requestList = new ArrayList<Request>();
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("TradingPlatformWeb");
		EntityManager em = emf.createEntityManager();
		Query query = em.createNativeQuery(
				"SELECT * FROM REQUEST WHERE SHAREHOLDER_ID = '" + id
						+ "'  AND STATUS='ACTIVE'", Request.class);

		requestList = (ArrayList<Request>) query.getResultList();
		return (ArrayList<Request>) requestList;
	}

}
