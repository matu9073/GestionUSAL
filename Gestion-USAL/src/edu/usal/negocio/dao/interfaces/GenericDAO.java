package edu.usal.negocio.dao.interfaces;
import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
	
	T create();	
	void saveOrUpdate(T entity);	
	void save(T entity);
	void update(T entity);
	T get(ID id);	
	void delete(ID id);	
	List<T> findAll();
	
}
