package com.williansmartins.teste;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.williansmartins.dao.entity.QuestaoDaoImpl;
import com.williansmartins.entity.QuestaoEntity;
import com.williansmartins.massa.QuestaoMassa;
import com.williansmartins.vo.QuestaoVO;

public class QuestaoTest {
	QuestaoDaoImpl dao;
	QuestaoEntity entityMockada1;
	QuestaoEntity entityMockada2;
	
	public QuestaoTest(){
		dao = new QuestaoDaoImpl();
	}
	
	@Test
	public void inserirEntity() throws Exception {
		QuestaoEntity entityMockada1 = new QuestaoEntity();
		entityMockada1 = new QuestaoMassa().getEntity1();
		
		dao.insert(entityMockada1);
		
		QuestaoEntity entityBanco = dao.findById(entityMockada1.getId());
		
		//Testar se inseriu mesmo
		Assert.assertNotNull(entityBanco );
		
	}

	@Test
	public void inserirERemoverEntity() throws Exception {
		QuestaoEntity entityMockada1 = new QuestaoEntity();
		entityMockada1 = new QuestaoMassa().getEntity1();

		dao.insert(entityMockada1);

		QuestaoEntity entityBanco = dao.findById(entityMockada1.getId());
		
		//Testar se inseriu mesmo
		Assert.assertNotNull( entityBanco );
		
		//Testar se removeu a entidade	
		dao.delete(entityMockada1.getId());
		Assert.assertNull(dao.findById(entityMockada1.getId()));
		
	}
	
	@Test
	public void buscarEntity() throws Exception {
		entityMockada1 = dao.findById(1);
		
		//Testar se inseriu mesmo
		Assert.assertNotNull( entityMockada1 );
	}

	@Test
	public void listarEntities() throws Exception {
		List<QuestaoEntity> listaEntities = new ArrayList<QuestaoEntity>();

		// Inserir 10 entities
		for (int cont = 0; cont < 10; cont++) {
			QuestaoEntity entityMockada1 = new QuestaoEntity();
			entityMockada1 = new QuestaoMassa().getEntity1();
			listaEntities.add(entityMockada1);
		}

		dao.insertAll(listaEntities);

		// Testar se inseriu as 10
		Assert.assertTrue(dao.findAll().size() > 9);
		Assert.assertNotNull(dao.findById(listaEntities.get(0).getId()));
		Assert.assertNotNull(dao.findById(listaEntities.get(9).getId()));

		// Remover as entities
		for (QuestaoEntity entity : listaEntities) {
			dao.delete(entity.getId());
		}

		// Verificar se elas realmente não estão no banco
		Assert.assertNull(dao.findById(listaEntities.get(0).getId()));
		Assert.assertNull(dao.findById(listaEntities.get(9).getId()));

	}
	
	@Test
	public void buscarPorAssunto(){
		List<QuestaoVO> lista = dao.buscarPorTema("HTML");
		Assert.assertNotNull(lista);
	}

}