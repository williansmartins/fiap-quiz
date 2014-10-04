package com.williansmartins.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import com.williansmartins.entity.ImovelEntity;
import com.williansmartins.enums.Tipo;

public class JpaGenericDao<T extends Serializable> implements Dao<T> {

	@PersistenceContext
	private EntityManager entityManager;
	private EntityManagerFactory emf;
	List<T> lista;

	public JpaGenericDao() {
		emf = Persistence.createEntityManagerFactory("manager-mysql");
		entityManager = getEntityManager();
	}

	public void insert(T entity) {
		entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("ERRO: " + e.getCause().getCause()
					+ e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	public List<T> findAll() {
		entityManager = getEntityManager();
		CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder()
				.createQuery(getGenericClass());
		criteriaQuery.from(getGenericClass());
		List<T> lista = entityManager.createQuery(criteriaQuery)
				.getResultList();
		entityManager.close();
		return lista;
	}

	public List<T> findEspecific(Integer id) {
		entityManager = getEntityManager();
		//entityManager.getTransaction().begin();
		String jpql = "select a from Avaliacao a";

		Query query = entityManager.createQuery(jpql);
		lista = query.getResultList();
		System.out.println("BUSCANDO :" + id);
		//entityManager.getTransaction().commit();
		if (lista.size() > 0) {
			entityManager.close();
			return lista;
		} else {
			entityManager.close();
			return null;
		}
	}

	public void delete(Integer primaryKey) {
		entityManager = getEntityManager();
		try {
			T entity = (T) entityManager.find(getGenericClass(), primaryKey);
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">> " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	public T findById(Integer primaryKey) {
		entityManager = getEntityManager();
		T entity = null;
		try {
			// Consulta um Cliente pelo seu ID.
			entity = (T) entityManager.find(getGenericClass(), primaryKey);
			return entity;
		} catch (Exception e) {
			System.out.println(">> " + e.getMessage());
			return null;
		} finally {
			entityManager.close();
		}
	}

	public void update(T entity) {
		entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			// return true; op��o para exibir se foi atualizado com sucesso
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			// return false;
		} finally {
			entityManager.close();
		}
	}

	@SuppressWarnings("unchecked")
	private Class<T> getGenericClass() {
		return (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		if (entityManager == null || !(entityManager.isOpen())) {
			return emf.createEntityManager();
		}
		return entityManager;
	}

	public void insertAll(List<T> entities) {
		for (T t : entities) {
			insert(t);
		}
	}

}
