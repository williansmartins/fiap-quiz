package com.williansmartins.dao.entity;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.entity.ClienteEntity;

public class ClienteDaoImpl extends JpaGenericDao<ClienteEntity> implements IClienteDao{
	
	private static Integer count = 0 ;
	
	public ClienteDaoImpl(){
		count++;
	}

	public static Integer getCount() {
		return count;
	}
	
}

