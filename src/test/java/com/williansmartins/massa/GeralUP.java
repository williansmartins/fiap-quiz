package com.williansmartins.massa;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.CorretorDaoImpl;
import com.williansmartins.dao.entity.ImovelDaoImpl;
import com.williansmartins.entity.CorretorEntity;
import com.williansmartins.entity.ImovelEntity;

public class GeralUP {
	JpaGenericDao<CorretorEntity> dao1 = new CorretorDaoImpl();
	JpaGenericDao<ImovelEntity> dao2 = new ImovelDaoImpl();
	
	@Test
	public void up() {
		new CorretorMassa().inserirCorretor();
		Assert.assertEquals(false, dao1.findAll().size() == 0);
		new ImovelMassa().inserirImovel();
		Assert.assertEquals(false, dao2.findAll().size() == 0);
	}
}
