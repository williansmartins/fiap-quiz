package com.williansmartins.massa;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.QuestaoDaoImpl;
import com.williansmartins.entity.QuestaoEntity;

public class QuestaoMassa {
	
	JpaGenericDao<QuestaoEntity> dao;
	
	public QuestaoMassa(){
		dao = new QuestaoDaoImpl();
	}

	@Test
	public void inserir() {
		dao.insert(getEntity1());
	}
	
	public QuestaoEntity getEntity1( ) {
		QuestaoEntity entity = new QuestaoEntity();
		entity.setPergunta("Quem descobriu o Brasil?");
		entity.setRespostaA("Mario");
		entity.setRespostaB("Luigi");
		entity.setRespostaC("Willians");
		entity.setRespostaD("Pedro");
		entity.setRespostaE("Peter");
		entity.setCorreta('d');
		entity.setTema("geral");
		
		return entity;
	}
	
	public void removerEntities() {
		for (QuestaoEntity o : dao.findAll()) {
			dao.delete( o.getId() );
		}
	}
	
	public void testeDeStress() throws Exception {
		List<QuestaoEntity> listaEntities = new ArrayList<QuestaoEntity>();
		
		for (int cont = 0; cont < 200; cont++) {
			QuestaoEntity entityMockada1 = new QuestaoEntity();
			entityMockada1 = new QuestaoMassa().getEntity1();
			listaEntities.add(entityMockada1);
		}
		
		dao.insertAll(listaEntities);
	}

}
