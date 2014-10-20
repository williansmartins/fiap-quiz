package com.williansmartins.massa;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.FotoDaoImpl;
import com.williansmartins.entity.FotoEntity;

public class FotoMassa {
	
	JpaGenericDao<FotoEntity> dao;
	
	public FotoMassa(){
		dao = new FotoDaoImpl();
	}

	@Test
	public void inserirImovel() {
		dao.insert(getEntityData());
	}
	
	public FotoEntity getEntityData( ) {
		FotoEntity entity = new FotoEntity();
		entity.setThumb("thumb");
		return entity;
	}
	
	public void removerImovel() {
		for (FotoEntity o : dao.findAll()) {
			dao.delete( o.getId() );
		}
	}
}