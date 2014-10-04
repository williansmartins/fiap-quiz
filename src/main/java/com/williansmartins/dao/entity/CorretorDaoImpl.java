package com.williansmartins.dao.entity;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.entity.CorretorEntity;

public class CorretorDaoImpl extends JpaGenericDao<CorretorEntity> implements ICorretorDao{
	
	private static Integer count = 0 ;
	
	public CorretorDaoImpl(){
		count ++;
	}
	
	public static Integer getCount() {
		return count;
	}
}

