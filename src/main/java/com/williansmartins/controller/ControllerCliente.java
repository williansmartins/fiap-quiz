package com.williansmartins.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.ClienteDaoImpl;
import com.williansmartins.entity.ClienteEntity;

@ManagedBean(name="clienteBean")
@RequestScoped
public class ControllerCliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ClienteEntity entity;
	private JpaGenericDao<ClienteEntity> dao = new ClienteDaoImpl();
	private List<ClienteEntity> lista;
	
	public ControllerCliente(){
	}
	
	public String save(){
		dao.insert(entity);
		entity = new ClienteEntity();
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
		entity = new ClienteEntity();
		System.out.println("insert");
		return "inserir.xhtml?faces-redirect=true";
	}	
	
	public List<ClienteEntity> getPedidoList() {
		return dao.findAll();
	}

	public ClienteEntity getEntity() {
		return entity;
	}

	public void setEntity(ClienteEntity entity) {
		this.entity = entity;
	}

	public List<ClienteEntity> getLista() {
		return lista;
	}

	public void setLista(List<ClienteEntity> lista) {
		this.lista = lista;
	}
	
}
