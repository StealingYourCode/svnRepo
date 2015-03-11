package dao;

import dto.IStorable;
import dto.UserDTO;
import exceptions.NoUserException;

public interface IStorage <T extends IStorable, P, I > {
	
	public IStorable create(T storable);
	
	public IStorable read(P uniquevalue) throws NoUserException;
	
	public void update(T oldstorable, T newstorable);
	
	public void delete(I id) throws NoUserException;
	

}