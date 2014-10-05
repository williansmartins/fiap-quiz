package com.williansmartins.teste;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.ClienteDaoImpl;
import com.williansmartins.entity.ClienteEntity;
import com.williansmartins.massa.ClienteMassa;

@SuppressWarnings("deprecation")
public class ClienteTest {
	JpaGenericDao<ClienteEntity> dao;
	
	@Test
	public void inserirERemoverEntity() {
		dao = new ClienteDaoImpl();
		ClienteEntity entityMockada = new ClienteEntity();
		entityMockada = new ClienteMassa().popularEntity(entityMockada);
		
		dao.insert(entityMockada);
		
		Assert.assertNotNull( dao.findById(entityMockada.getId()) );
		Assert.assertTrue( dao.findById(entityMockada.getId()).getInteresse().equalsIgnoreCase("imovel x") );
		
		dao.delete( entityMockada.getId() );
		Assert.assertNull( dao.findById(entityMockada.getId()) );
		
	}
	
	@Test
	public void listarEntities() {
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
		
		//Remover as entities
		for (ClienteEntity entity : listaEntities) {
			dao.delete(entity.getId());
		}
		
		//Verificar se elas realmente não estão no banco
		Assert.assertNull( dao.findById(listaEntities.get(0).getId())  );
		Assert.assertNull( dao.findById(listaEntities.get(9).getId())  );
		
	}
	
}