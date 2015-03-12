package jpa;

import dao.IStorage;
import dto.IStorable;
import dto.RequestDTO;
import exceptions.NoUserException;
import exceptions.StorableNotFoundException;

public class Request_DAO_JPA implements IStorage<RequestDTO, Integer, Integer>{

	@Override
	public IStorable create(RequestDTO storable) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStorable read(Integer id) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(RequestDTO oldstorable, RequestDTO newstorable)
			throws StorableNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
