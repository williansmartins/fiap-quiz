package com.williansmartins.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.ImovelDaoImpl;
import com.williansmartins.entity.ImovelEntity;
import com.williansmartins.entity.Tipo;

@ManagedBean(name="imovelBean")
@RequestScoped
public class ControllerImovel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ImovelEntity entity;
	private JpaGenericDao<ImovelEntity> dao = new ImovelDaoImpl();
	private List<ImovelEntity> novidades;
	private List<ImovelEntity> lista;
	private int idDoImovel;
	BigDecimal min;
	BigDecimal max;
	Tipo tipo; 
	
	public ControllerImovel(){
	}
	
	public void buscarImovel(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		idDoImovel = Integer.parseInt( request.getParameter("imovel_id") );
		entity = dao.findById(idDoImovel);
		System.out.println(">>>" + entity.getTitulo());
	}
	
	public void buscarImoveis(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if( request.getParameter("min") != null){
			min = new BigDecimal(request.getParameter("min"));
		}
		if( request.getParameter("max") != null){
			max = new BigDecimal(request.getParameter("max"));
		}
		if( request.getParameter("tipo") != null){
			tipo = request.getParameter("tipo").equalsIgnoreCase("casa") ? Tipo.CASA : Tipo.APARTAMENTO;
		}
		
		String cidade = request.getParameter("cidade");
		
		lista = dao.find(tipo, cidade,  min ,  max );
	}
	
	@PostConstruct
	public void init() {
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

	public List<ImovelEntity> getNovidades() {
		return dao.findAll();
	}

	public void setNovidades(List<ImovelEntity> novidades) {
		this.novidades = novidades;
	}

	public List<ImovelEntity> getLista() {
		return lista;
	}

	public void setLista(List<ImovelEntity> lista) {
		this.lista = lista;
	}
	
}
