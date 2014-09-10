package com.williansmartins.dao.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.entity.CorretorEntity;

public class CorretorDaoImpl extends JpaGenericDao<CorretorEntity> implements ICorretorDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	List<CorretorEntity> lista;
	
	public CorretorDaoImpl() {
		entityManager = getEntityManager();
	}
}

