package com.williansmartins.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.ImovelDaoImpl;
import com.williansmartins.entity.ImovelEntity;

@ManagedBean(name="imovelBean")
@SessionScoped
public class ControllerImovel {
	
	private ImovelEntity entity;
	private JpaGenericDao<ImovelEntity> dao = new ImovelDaoImpl();
	
	public ControllerImovel(){
		entity = new ImovelEntity();
	}
	
	public String home(){
		entity = new ImovelEntity();
		return "index.xhtml?faces-redirect=true";
	}
	
	public String list(){
		entity = new ImovelEntity();
		return "lista.xhtml?faces-redirect=true";
	}
	
	public String save(){
		dao.insert(entity);
		entity = new ImovelEntity();
		return "lista.xhtml";
	}
	
	public String remove(){
		dao.delete(entity.getId());
		return "lista.xhtml";
	}	
	
	public String incAlt(){
		entity = dao.findById(entity.getId());
		return "inserir.xhtml";
	}	
	
	public String prepareInsert(){
		entity = new ImovelEntity();
		System.out.println("insert");
		return "inserir.xhtml?faces-redirect=true";
	}	
	
	public List<ImovelEntity> getPedidoList() {
		return dao.findAll();
	}

	public ImovelEntity getEntity() {
		return entity;
	}

	public void setEntity(ImovelEntity entity) {
		this.entity = entity;
	}
	
}
