package com.williansmartins.massa;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.QuestaoDaoImpl;
import com.williansmartins.dao.entity.UserDaoImpl;
import com.williansmartins.entity.QuestaoEntity;
import com.williansmartins.entity.UserEntity;

public class GeralUP {
	JpaGenericDao<QuestaoEntity> dao1;
	JpaGenericDao<UserEntity> dao2;
	
	public GeralUP(){
		dao1 = new QuestaoDaoImpl();
		dao2 = new UserDaoImpl();
	}
	
	@Test
	public void up() {
		new QuestaoMassa().inserir();
		Assert.assertEquals(true, dao1.findAll().size() == 1);
		new UserMassa().inserir();
		Assert.assertEquals(true, dao2.findAll().size() == 4);
	}
}
