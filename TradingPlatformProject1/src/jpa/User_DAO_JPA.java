package jpa;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IStorage;
import dto.IStorable;
import dto.UserDTO;
import exceptions.StorableNotFoundException;

public class User_DAO_JPA implements IStorage<UserDTO, String, Integer> {


	@Override
	public UserDTO create(UserDTO user) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		if(user==null)
			throw new StorableNotFoundException("This user does not exist");

		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
		return user;
	}

	public UserDTO read(Integer id) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		try{
		UserDTO result = em.find(UserDTO.class, id);
		
		em.close();
		emf.close();
		return result;
		
		}catch (NoResultException e){
			e.printStackTrace();
			throw new StorableNotFoundException("This user does not exist");
			
		}
		
	}

	@Override
	public void update(UserDTO olduser, UserDTO newuser) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		
		if(olduser == null || newuser == null)
			throw new StorableNotFoundException("This user does not exist");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		UserDTO result = em.find(UserDTO.class, olduser.getUserID());
		
		em.getTransaction().begin();
		result.setPassword(newuser.getPassword());
		result.setFirstname(newuser.getFirstname());
		result.setLastname(newuser.getLastname());
		result.setUsername(newuser.getUsername());
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

	@Override
	public void delete(Integer id) throws StorableNotFoundException {
		
		User_DAO_JPA dao = new User_DAO_JPA();
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		if(em.find(UserDTO.class, id)==null)
			throw new StorableNotFoundException("This user does not exist");
		
		em.getTransaction().begin();
		em.remove(em.find(UserDTO.class, id));
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		// TODO Auto-generated method stub
	}

	
	
	/************************************************************************************/
	@Override
	public UserDTO read(String username) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");
		EntityManager em = emf.createEntityManager();
		Query query = em.createNativeQuery("SELECT * FROM PERSON WHERE USER_NAME = '" + username +"'" , UserDTO.class);
		try{
		UserDTO result = (UserDTO) query.getSingleResult();
		return result;
		}catch(NoResultException e){
			e.printStackTrace();
			throw new StorableNotFoundException("This user does not exist");
		}
		
	}

}
