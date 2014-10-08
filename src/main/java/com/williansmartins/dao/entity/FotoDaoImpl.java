package com.williansmartins.dao.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.entity.FotoEntity;
import com.williansmartins.entity.ImovelEntity;

public class FotoDaoImpl extends JpaGenericDao<FotoEntity> implements IFotoDao, Serializable{
	
	private static final long serialVersionUID = 1L;
	private static Integer count = 0 ;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public FotoDaoImpl() {
	
	}
	
	public static Integer getCount() {
		return count;
	}

//	public void insert(FotoEntity entityMockada1, int i) {
//		entityManager = getEntityManager();
//		entityManager.getTransaction().begin();
//		
//		String jpql = "insert into Foto (id, grande, thumb,imovel_id) select c.id, c.name from Customer c where ...";
//		"insert into Student(studentName, studentAge,)" + " select studentName, studentAge from old_student"
//		
//		
//		Query query = entityManager.createQuery(jpql);
//	}
	
}

