package com.williansmartins.dao.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.entity.UserEntity;

public class UserDaoImpl extends JpaGenericDao<UserEntity> implements IUserDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean existeUsuario(UserEntity user) {
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		
		String jpql = "SELECT p FROM user p WHERE p.cpf = '" + user.getCpf() + "' ";
		
		Query query = entityManager.createQuery(jpql);
		
		entityManager.flush();
		entityManager.close();

		return query.getResultList().size() > 0;
	}
	
}

