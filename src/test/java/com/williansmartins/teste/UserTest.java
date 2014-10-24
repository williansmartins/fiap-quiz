package com.williansmartins.teste;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.entity.UserDaoImpl;
import com.williansmartins.entity.UserEntity;
import com.williansmartins.massa.UserMassa;

@SuppressWarnings("deprecation")
public class UserTest {
	UserDaoImpl dao;
	UserEntity entityMockada1;
	UserEntity entityMockada2;
	
	public UserTest(){
		dao = new UserDaoImpl();
	}
	
	@Test
	public void inserirEntity() throws Exception {
		UserEntity entityMockada1 = new UserEntity();
		entityMockada1 = new UserMassa().getEntity1();
		
		dao.insert(entityMockada1);
		
		UserEntity entityBanco = dao.findById(entityMockada1.getId());
		
		//Testar se inseriu mesmo
		Assert.assertNotNull(entityBanco );
		
	}

	@Test
	public void inserirERemoverEntity() throws Exception {
		UserEntity entityMockada1 = new UserEntity();
		entityMockada1 = new UserMassa().getEntity1();

		dao.insert(entityMockada1);

		UserEntity entityBanco = dao.findById(entityMockada1.getId());
		
		//Testar se inseriu mesmo
		Assert.assertNotNull(entityBanco );
		
		//Testar se removeu a entidade	
		dao.delete(entityMockada1.getId());
		Assert.assertNull(dao.findById(entityMockada1.getId()));
		
	}
	
	@Test
	public void buscarEntity() throws Exception {
		entityMockada1 = dao.findById(1);
		
		Assert.assertNotNull( entityMockada1.getRespostas().get(0).getNumero() == 1);
		Assert.assertNotNull( entityMockada1.getRespostas().get(0).getRespondeu().equalsIgnoreCase("A"));
		Assert.assertNotNull( entityMockada1.getRespostas().get(0).getAcertou().equalsIgnoreCase("sim"));
		
		//Testar se inseriu mesmo
		Assert.assertNotNull( entityMockada1 );
	}

	@Test
	public void listarEntities() throws Exception {
		List<UserEntity> listaEntities = new ArrayList<UserEntity>();

		// Inserir 10 entities
		for (int cont = 0; cont < 10; cont++) {
			UserEntity entityMockada1 = new UserEntity();
			entityMockada1 = new UserMassa().getEntity1();
			listaEntities.add(entityMockada1);
		}

		dao.insertAll(listaEntities);

		// Testar se inseriu as 10
		Assert.assertTrue(dao.findAll().size() > 9);
		Assert.assertNotNull(dao.findById(listaEntities.get(0).getId()));
		Assert.assertNotNull(dao.findById(listaEntities.get(9).getId()));

		// Remover as entities
		for (UserEntity entity : listaEntities) {
			dao.delete(entity.getId());
		}

		// Verificar se elas realmente não estão no banco
		Assert.assertNull(dao.findById(listaEntities.get(0).getId()));
		Assert.assertNull(dao.findById(listaEntities.get(9).getId()));

	}

}