package com.williansmartins.massa;


import org.junit.Assert;
import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.QuestaoDaoImpl;
import com.williansmartins.dao.entity.UserDaoImpl;
import com.williansmartins.entity.QuestaoEntity;
import com.williansmartins.entity.UserEntity;

public class GeralDown {
	JpaGenericDao<QuestaoEntity> dao1;
	JpaGenericDao<UserEntity> dao2;
	
	public GeralDown(){
		dao1 = new QuestaoDaoImpl();
		dao2 = new UserDaoImpl();
	}
	
	@Test
	public void down() {
		new QuestaoMassa().removerEntities();
		Assert.assertEquals(true, dao1.findAll().size() == 0);
		new UserMassa().removerEntities();
		Assert.assertEquals(true, dao2.findAll().size() == 0);
	}
}
