package com.williansmartins.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.williansmartins.dao.entity.ClienteDaoImpl;
import com.williansmartins.entity.ClienteEntity;

@ManagedBean(name="clienteBean")
@SessionScoped
public class ControllerCliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ClienteEntity entity;
	private ClienteDaoImpl dao;
	private List<ClienteEntity> lista;
	private int imovel_id;
	
	public ControllerCliente(){
		dao = new ClienteDaoImpl();
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
	
	public String salvarSomente(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		imovel_id = Integer.parseInt( request.getParameter("modal-cliente:imovel_id") );
		//entity.setInteresse(request.getParameter("modal-cliente:interesse") );
		dao.insert(entity);
		return "imovel.xhtml?imovel_id=" + imovel_id + "&faces-redirect=true";
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

	public int getImovel_id() {
		return imovel_id;
	}

	public void setImovel_id(int imovel_id) {
		this.imovel_id = imovel_id;
	}
	
}
