package com.williansmartins.teste;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.CorretorDaoImpl;
import com.williansmartins.entity.CorretorEntity;
import com.williansmartins.massa.CorretorMassa;

@SuppressWarnings("deprecation")
public class CorretorTest {
	JpaGenericDao<CorretorEntity> dao;
	
	public CorretorTest(){
		dao = new CorretorDaoImpl();
	}
	
	@Test
	public void inserirMesmoSemOsOutrosDados() {
		CorretorEntity entityMockada = new CorretorEntity();
		entityMockada.setNome("willians");
		dao.insert(entityMockada);
		
		//Testar se gravou
		Assert.assertNotNull( dao.findById(entityMockada.getId()) );
		
		//Testar se removeu a entidade	
		dao.delete(entityMockada.getId());
		Assert.assertNull(dao.findById(entityMockada.getId()));
	}
	
	@Test
	public void inserirERemoverEntity() {
		CorretorEntity entityMockada = new CorretorEntity();
		entityMockada = new CorretorMassa().popularEntity(entityMockada);
		
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
			entityMockada = new CorretorMassa().popularEntity(entityMockada);
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
		
		//Verificar se elas realmente n�o est�o no banco
		Assert.assertNull( dao.findById(listaEntities.get(0).getId())  );
		Assert.assertNull( dao.findById(listaEntities.get(9).getId())  );
		
	}
}