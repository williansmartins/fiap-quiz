package com.williansmartins.massa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.UserDaoImpl;
import com.williansmartins.entity.RepostaEntity;
import com.williansmartins.entity.UserEntity;

public class UserMassa {
	
	JpaGenericDao<UserEntity> dao;
	
	public UserMassa(){
		dao = new UserDaoImpl();
	}

	@Test
	public void inserir() {
		dao.insert(getEntity1());
	}
	
	public UserEntity getEntity1( ) {
		UserEntity entity = new UserEntity();
		entity.setCpf("30580911845");
		entity.setNome("Willians Martin");
		List<RepostaEntity> respostas = new ArrayList<RepostaEntity>();
		RepostaEntity r1 = new RepostaEntity(1, "A", "sim");
		RepostaEntity r2 = new RepostaEntity(2, "B", "nao");
		RepostaEntity r3 = new RepostaEntity(3, "C", "sim");
		RepostaEntity r4 = new RepostaEntity(4, "A", "sim");
		
		respostas.add( r1 );
		respostas.add( r2 );
		respostas.add( r3 );
		respostas.add( r4 );
		
		entity.setRespostas(respostas );
		
		return entity;
	}
	
	public void removerEntities() {
		for (UserEntity o : dao.findAll()) {
			dao.delete( o.getId() );
		}
	}
	
	public void testeDeStress() throws Exception {
		List<UserEntity> listaEntities = new ArrayList<UserEntity>();
		
		for (int cont = 0; cont < 200; cont++) {
			UserEntity entityMockada1 = new UserEntity();
			entityMockada1 = new UserMassa().getEntity1();
			listaEntities.add(entityMockada1);
		}
		
		dao.insertAll(listaEntities);
	}

}
