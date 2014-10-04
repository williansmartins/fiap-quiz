package com.williansmartins.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.CorretorDaoImpl;
import com.williansmartins.entity.CorretorEntity;

@ManagedBean(name="corretorBean")
@SessionScoped
public class ControllerCorretor implements Serializable{

	private static final long serialVersionUID = 2L;
	private CorretorEntity entity;
	private JpaGenericDao<CorretorEntity> dao;
	
	public ControllerCorretor(){
		dao = new CorretorDaoImpl();
		entity = dao.findAll().size() > 0 ? dao.findAll().get(0) : new CorretorEntity();
	}
	
	public String save(){
		entity.setId(dao.findAll().get(0).getId());
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
