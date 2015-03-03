package dao;

import dto.IStorable;
import dto.UserDTO;

public interface IStorage <T> {
	
	public IStorable create(T storable, int id);
	
	public IStorable read(T storable);
	
	public void update(T oldstorable, T newstorable);
	
	public void delete(T storable);
	

}