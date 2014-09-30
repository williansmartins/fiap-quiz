package com.williansmartins.dao.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.entity.ImovelEntity;
import com.williansmartins.enums.Tipo;

public class ImovelDaoImpl extends JpaGenericDao<ImovelEntity> implements IImovelDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	List<ImovelEntity> lista;
	
	public ImovelDaoImpl() {
		entityManager = getEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public List<ImovelEntity> find(String s) {
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		
		String jpql = "SELECT p FROM imovel p WHERE p.titulo like '%" + s + 
				"%' or p.cidade like '%" + s + 
				"%' or p.descricaoCompleta like '%" + s +
				"%' or p.endereco like '%" + s +
				"%' or p.tipo like '%" + s + "%' ";
		
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
	
	@SuppressWarnings("unchecked")
	public List<ImovelEntity> find(Tipo tipo, String cidade, BigDecimal minimo, BigDecimal maximo) {
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		
		cidade = cidade == null || cidade.equalsIgnoreCase("qualquer") ? "" : cidade;
		String tipoS = tipo == null || tipo == Tipo.QUALQUER ? "" : tipo.toString();
		String minimoS = minimo == null ? "0" : minimo.toString();
		String maximoS = maximo == null ? "99999999999999999" : maximo.toString();
		
		String jpql = "SELECT p FROM imovel p WHERE p.cidade like '%%" + cidade +
				"%%' and p.tipo like '%%" + tipoS + 
				"%%' and p.valor >= " + minimoS + " and p.valor <= " + maximoS + "";
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
	
	@SuppressWarnings("unchecked")
	public List<String> findCityes() {
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		
		String jpql = "SELECT DISTINCT(cidade) FROM imovel";
		Query query = entityManager.createQuery(jpql);
		List<String> lista = (List<String>)query.getResultList();
		
		entityManager.flush();
		
		entityManager.close();
		if(lista.size() > 0){
			return lista;
		}else{
			return null;
		}
	}

	
}

