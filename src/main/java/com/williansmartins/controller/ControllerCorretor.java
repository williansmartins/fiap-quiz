package com.williansmartins.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.CorretorDaoImpl;
import com.williansmartins.entity.CorretorEntity;

@ManagedBean(name="corretorBean")
@SessionScoped
public class ControllerCorretor {
	
	private CorretorEntity entity;
	private JpaGenericDao<CorretorEntity> dao = new CorretorDaoImpl();
	
	public ControllerCorretor(){
		entity = dao.findById(1);
	}
	
	public String save(){
		entity.setId(1);
		dao.update(entity);
		return "admin-corretor.xhtml";
	}
	
	public CorretorEntity getEntity() {
		return entity;
	}

	public void setEntity(CorretorEntity entity) {
		this.entity = entity;
	}
	
}
