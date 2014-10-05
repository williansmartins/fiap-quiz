package com.williansmartins.massa;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.CorretorDaoImpl;
import com.williansmartins.entity.CorretorEntity;

public class CorretorMassa {
	
	JpaGenericDao<CorretorEntity> dao;
	
	public CorretorMassa(){
		dao = new CorretorDaoImpl();
	}

	@Test
	public void inserirCorretor() {
		CorretorEntity entityMockada = new CorretorEntity();
		entityMockada = popularEntity(entityMockada);
		dao.insert(entityMockada);
	}
	
	public CorretorEntity popularEntity(CorretorEntity entity){
		entity.setNome("Washington L. M. de Morais");
		entity.setCelular("(11) 993-650-220");
		entity.setTelefone("(11) 4148-4583");
		entity.setEmail("contato@gmail.com");
		return entity;
	}

	public void removerCorretor() {
		for (CorretorEntity o : dao.findAll()) {
			dao.delete( o.getId() );
		}
	}
}
