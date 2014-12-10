package com.williansmartins.teste;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.williansmartins.dao.entity.UserDaoImpl;
import com.williansmartins.entity.UserEntity;
import com.williansmartins.massa.UserMassa;

public class UserTest {
	UserDaoImpl dao;
	UserEntity entityMockada;
	UserEntity entityMockada2;
	UserEntity entityBanco;
	
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
		//crio uma entity mokada
		entityMockada = new UserMassa().getEntity1();
		
		//persisto ela no banco
		entityBanco = dao.insert(entityMockada);
		
		//busco ela no banco para ver se inseriu
		entityBanco = dao.findById( entityBanco.getId() );
		
		//verifico se foi tudo persistido
		
		Assert.assertNotNull( entityBanco );
		if ( entityBanco != null && entityBanco.getRespostas() != null && entityBanco.getRespostas().get(0) != null && entityMockada.getRespostas().get(0).getRespondeu() != null && entityMockada.getRespostas().get(0).getAcertou() != null ){
			Assert.assertNotNull( entityMockada.getRespostas().get(0).getNumero() == 1);
			Assert.assertNotNull( entityMockada.getRespostas().get(0).getRespondeu().equalsIgnoreCase("A"));
			Assert.assertNotNull( entityMockada.getRespostas().get(0).getAcertou().equalsIgnoreCase("sim"));
		}
		
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