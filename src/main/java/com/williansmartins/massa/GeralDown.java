package com.williansmartins.massa;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.ClienteDaoImpl;
import com.williansmartins.dao.entity.CorretorDaoImpl;
import com.williansmartins.dao.entity.ImovelDaoImpl;
import com.williansmartins.entity.ClienteEntity;
import com.williansmartins.entity.CorretorEntity;
import com.williansmartins.entity.ImovelEntity;

public class GeralDown {
	JpaGenericDao<CorretorEntity> dao1;
	JpaGenericDao<ImovelEntity> dao2;
	JpaGenericDao<ClienteEntity> dao3;
	
	public GeralDown(){
		dao1 = new CorretorDaoImpl();
		dao2 = new ImovelDaoImpl();
		dao3 = new ClienteDaoImpl();
	}
	
	@Test
	public void down() {
		new CorretorMassa().removerCorretor();
		Assert.assertEquals(true, dao1.findAll().size() == 0);
		new ImovelMassa().removerImovel();
		Assert.assertEquals(true, dao2.findAll().size() == 0);
		new ClienteMassa().removerTudo();
		Assert.assertEquals(true, dao3.findAll().size() == 0);
	}
}
