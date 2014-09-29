package com.williansmartins.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.ClienteDaoImpl;
import com.williansmartins.entity.ClienteEntity;
import com.williansmartins.entity.ImovelEntity;

@ManagedBean(name="clienteBean")
@RequestScoped
public class ControllerCliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ClienteEntity entity;
	private JpaGenericDao<ClienteEntity> dao = new ClienteDaoImpl();
	private List<ClienteEntity> lista;
	
	public ControllerCliente(){
		entity = new ClienteEntity();
		lista = dao.findAll();
	}
	
	public String excluir(String id){
		dao.delete(Integer.parseInt(id));
		lista = dao.findAll();
		return "admin-clientes.xhtml?faces-redirect=true";
	}	

	public void viewEntity(String id){
		entity = dao.findById(Integer.parseInt(id));
	}
	
	public String salvar(){
		if(entity.getId() == null){
			dao.insert(entity);
		}else{
			dao.update(entity);
		}
		entity = new ClienteEntity();
		lista = dao.findAll();
		return "admin-clientes.xhtml?faces-redirect=true";
	}
	
	public void novo(){
		entity = new ClienteEntity();
	}	
	
	////// GETTERS AND SETTERS ///////////////
	/////////////////////////////////////////
	
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
