package com.williansmartins.teste;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.entity.FotoDaoImpl;
import com.williansmartins.entity.FotoEntity;
import com.williansmartins.entity.ImovelEntity;
import com.williansmartins.massa.FotoMassa;

@SuppressWarnings("deprecation")
public class FotoTest {
	FotoDaoImpl dao;
	FotoEntity entityMockada1;
	
	public FotoTest(){
		dao = new FotoDaoImpl();
	}

	@Test
	public void inserirSomente() throws Exception {
		FotoEntity entityMockada1 = new FotoEntity();
		entityMockada1.setThumb("thumb");
		
		ImovelEntity imovelEntity = new ImovelEntity();
		imovelEntity.setId(69);

		dao.insert(entityMockada1);

		FotoEntity entityBanco = dao.findById(entityMockada1.getId());
		
		//Testar se inseriu mesmo
		Assert.assertNotNull(entityBanco );
	}
	
	@Test
	public void inserirERemoverEntity() throws Exception {
		FotoEntity entityMockada1 = new FotoEntity();
		entityMockada1 = new FotoMassa().getEntityData();
		
		dao.insert(entityMockada1);
		
		FotoEntity entityBanco = dao.findById(entityMockada1.getId());
		
		//Testar se inseriu mesmo
		Assert.assertNotNull(entityBanco );
		
		dao.delete(entityMockada1.getId());
		Assert.assertNull(dao.findById(entityMockada1.getId()));
	}

	@Test
	public void listarEntities() throws Exception {
		List<FotoEntity> listaEntities = new ArrayList<FotoEntity>();

		// Inserir 10 entities
		for (int cont = 0; cont < 10; cont++) {
			FotoEntity entityMockada1 = new FotoEntity();
			entityMockada1 = new FotoMassa().getEntityData();
			listaEntities.add(entityMockada1);
		}

		dao.insertAll(listaEntities);

		// Testar se inseriu as 10
		Assert.assertTrue(dao.findAll().size() > 9);
		Assert.assertNotNull(dao.findById(listaEntities.get(0).getId()));
		Assert.assertNotNull(dao.findById(listaEntities.get(9).getId()));

		// Remover as entities
		for (FotoEntity entity : listaEntities) {
			dao.delete(entity.getId());
		}

		// Verificar se elas realmente não estão no banco
		Assert.assertNull(dao.findById(listaEntities.get(0).getId()));
		Assert.assertNull(dao.findById(listaEntities.get(9).getId()));

	}
}