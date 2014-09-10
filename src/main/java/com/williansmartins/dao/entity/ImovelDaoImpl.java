package com.williansmartins.dao.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.entity.ImovelEntity;

public class ImovelDaoImpl extends JpaGenericDao<ImovelEntity> implements IImovelDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	List<ImovelEntity> lista;
	
	public ImovelDaoImpl() {
		entityManager = getEntityManager();
	}
}

