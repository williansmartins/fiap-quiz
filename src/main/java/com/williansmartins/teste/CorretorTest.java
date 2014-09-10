package com.williansmartins.teste;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.CorretorDaoImpl;
import com.williansmartins.entity.CorretorEntity;

@SuppressWarnings("deprecation")
public class CorretorTest {
	JpaGenericDao<CorretorEntity> dao = new CorretorDaoImpl();
	
	@Test
	public void inserirSomente() {
		CorretorEntity entityMockada = new CorretorEntity();
		entityMockada = popularEntity(entityMockada);
		dao.insert(entityMockada);
	}
	
	@Test
	public void inserirERemoverEntity() {
		CorretorEntity entityMockada = new CorretorEntity();
		entityMockada = popularEntity(entityMockada);
		
		dao.insert(entityMockada);
		
		Assert.assertNotNull( dao.findById(entityMockada.getId()) );
		
		dao.delete( entityMockada.getId() );
		Assert.assertNull( dao.findById(entityMockada.getId()) );
		
	}
	
	@Test
	public void listarEntities() {
		List<CorretorEntity> listaEntities = new ArrayList<CorretorEntity>();
		
		//Inserir 10 entities
		for  (int cont = 0; cont < 10; cont++) {
			CorretorEntity entityMockada = new CorretorEntity();
			entityMockada = popularEntity(entityMockada);
			listaEntities.add(entityMockada);
		}
		
		dao.insertAll(listaEntities);
		
		//Testar se inseriu as 10
		Assert.assertTrue( dao.findAll().size() > 9 );
		Assert.assertNotNull( dao.findById(listaEntities.get(0).getId())  );
		Assert.assertNotNull( dao.findById(listaEntities.get(9).getId())  );
		
		//Remover as entities
		for (CorretorEntity entity : listaEntities) {
			dao.delete(entity.getId());
		}
		
		//Verificar se elas realmente não estão no banco
		Assert.assertNull( dao.findById(listaEntities.get(0).getId())  );
		Assert.assertNull( dao.findById(listaEntities.get(9).getId())  );
		
	}
	
	public CorretorEntity popularEntity(CorretorEntity entity){
		
		entity.setNome("Washington Luis Martins de Morais");
		entity.setCelular("(11) 993-650-220");
		entity.setTelefone("(11) 4148-4583");
		entity.setEmail("contato@gmail.com");
		
		return entity;
	}
}