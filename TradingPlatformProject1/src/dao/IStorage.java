package dao;

import dto.IStorable;
import dto.UserDTO;
import exceptions.NoUserException;

public interface IStorage <T, P> {
	
	public IStorable create(T storable);
	
	public IStorable read(P p);
	
	public void update(T oldstorable, T newstorable);
	
	public void delete(T storable);
	

}