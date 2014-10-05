package com.williansmartins.massa;

import junit.framework.Assert;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.ClienteDaoImpl;
import com.williansmartins.dao.entity.CorretorDaoImpl;
import com.williansmartins.dao.entity.ImovelDaoImpl;
import com.williansmartins.entity.ClienteEntity;
import com.williansmartins.entity.CorretorEntity;
import com.williansmartins.entity.ImovelEntity;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Start {
	JpaGenericDao<CorretorEntity> dao1;
	JpaGenericDao<ImovelEntity> dao2;
	JpaGenericDao<ClienteEntity> dao3;
	
	public Start(){
		dao1 = new CorretorDaoImpl();
		dao2 = new ImovelDaoImpl();
		dao3 = new ClienteDaoImpl();
	}
	
	@Test
	public void apagarTodosCorretores() {
		new CorretorMassa().removerCorretor();
		Assert.assertEquals(true, dao1.findAll().size() == 0);
	}
	
	@Test
	public void apagarTodosImoveis() {
		new ImovelMassa().removerImovel();
		Assert.assertEquals(true, dao2.findAll().size() == 0);
	}
	
	@Test
	public void inserirCorretor() {
		new CorretorMassa().inserirCorretor();
		Assert.assertEquals(true, dao1.findAll().size() == 1);
	}
	
	@Test
	public void inserirImoveis() {
		new ImovelMassa().inserirImovel();
		Assert.assertEquals(true, dao2.findAll().size() == 4);
	}

	@Test
	public void apagarTodosClientes() {
		new ClienteMassa().removerTudo();
		Assert.assertEquals(true, dao3.findAll().size() == 0);
	}
	
	@Test
	public void inserirClientes() {
		new ClienteMassa().inserirUm();
		Assert.assertEquals(true, dao3.findAll().size() == 1);
	}
}
