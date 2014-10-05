package com.williansmartins.massa;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.ClienteDaoImpl;
import com.williansmartins.entity.ClienteEntity;

public class ClienteMassa {
	
	JpaGenericDao<ClienteEntity> dao;
	
	public ClienteMassa(){
		dao = new ClienteDaoImpl();
	}

	@Test
	public void inserirUm() {
		dao = new ClienteDaoImpl();
		ClienteEntity entityMockada = new ClienteEntity();
		entityMockada = popularEntity(entityMockada);
		dao.insert(entityMockada);
	}
	
	@Test
	public void inserirDez() {
		List<ClienteEntity> listaEntities = new ArrayList<ClienteEntity>();
		
		//Inserir 10 entities
		for  (int cont = 0; cont < 10; cont++) {
			ClienteEntity entityMockada = new ClienteEntity();
			entityMockada = new ClienteMassa().popularEntity(entityMockada);
			listaEntities.add(entityMockada);
		}
		
		dao.insertAll(listaEntities);
		
		//Testar se inseriu as 10
		Assert.assertTrue( dao.findAll().size() > 9 );
		Assert.assertNotNull( dao.findById(listaEntities.get(0).getId())  );
		Assert.assertNotNull( dao.findById(listaEntities.get(9).getId())  );
	}
	
	public ClienteEntity popularEntity(ClienteEntity entity){
		entity.setNome("Cliente1");
		entity.setCelular("(11) 993-650-220");
		entity.setTelefone("(11) 4148-4583");
		entity.setEmail("cliente1@gmail.com");
		entity.setInteresse("imovel x");
		return entity;
	}

	public void removerTudo() {
		for (ClienteEntity o : dao.findAll()) {
			dao.delete( o.getId() );
		}
	}
}
