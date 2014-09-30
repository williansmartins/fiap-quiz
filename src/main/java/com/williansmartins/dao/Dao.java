package com.williansmartins.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.williansmartins.enums.Tipo;

public interface Dao<T extends Serializable> {

	void insert(T entity);
	void update(T entity);
	void delete(Integer primaryKey) throws Exception;
	List<T> findAll();
	List<T> findEspecific(Integer id);
	T findById(Integer primaryKey);
	
}
