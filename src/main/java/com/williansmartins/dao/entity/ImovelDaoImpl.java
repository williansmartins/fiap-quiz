package com.williansmartins.dao.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.entity.ImovelEntity;

public class ImovelDaoImpl extends JpaGenericDao<ImovelEntity> implements IImovelDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	List<ImovelEntity> lista;
	
	public ImovelDaoImpl() {
		entityManager = getEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public List<ImovelEntity> findEspecific(String s) {
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		
		String jpql = "SELECT p FROM Imovel p WHERE p.titulo like '%" + s + "%'";
		Query query = entityManager.createQuery(jpql);
		lista = (List<ImovelEntity>)query.getResultList();
		
		
		entityManager.flush();
		
		entityManager.close();
		if(lista.size() > 0){
			return lista;
		}else{
			return null;
		}
	}
}

