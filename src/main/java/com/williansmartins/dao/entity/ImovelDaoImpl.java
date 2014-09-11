package com.williansmartins.dao.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.entity.ImovelEntity;
import com.williansmartins.entity.Tipo;

public class ImovelDaoImpl extends JpaGenericDao<ImovelEntity> implements IImovelDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	List<ImovelEntity> lista;
	
	public ImovelDaoImpl() {
		entityManager = getEntityManager();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ImovelEntity> find(String s) {
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		
<<<<<<< HEAD
		String jpql = "SELECT p FROM imovel p WHERE p.titulo like '%" + s + 
				"%' or p.cidade like '%" + s + 
				"%' or p.descricaoCompleta like '%" + s +
				"%' or p.endereco like '%" + s +
				"%' or p.tipo like '%" + s + "%' ";
		
=======
		String jpql = "SELECT p FROM imovel p WHERE p.titulo like '%" + s + "%'";
>>>>>>> c77f91d46fa7a2cb26713140a26959f82a194dfa
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
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ImovelEntity> find(Tipo tipo, String cidade, BigDecimal minimo, BigDecimal maximo) {
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		
		cidade = cidade == null ? "" : cidade;
		String tipoS = tipo == null ? "" : tipo.toString();
		
		String jpql = "SELECT p FROM imovel p WHERE p.cidade like '%" + cidade +
				"%' and p.tipo like '%%" + tipoS + 
				"%%' and p.valor >= " + minimo + " and p.valor <= " + maximo + "";
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

