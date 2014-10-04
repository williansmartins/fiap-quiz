package com.williansmartins.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.williansmartins.dao.entity.ClienteDaoImpl;
import com.williansmartins.dao.entity.CorretorDaoImpl;
import com.williansmartins.dao.entity.ImovelDaoImpl;
import com.williansmartins.massa.Start;

@ManagedBean(name="salaBean")
@SessionScoped
public class SalaDeControleBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public SalaDeControleBean(){
	}
	
	public void reset(){
		new Start().apagarTodosClientes();
		new Start().apagarTodosCorretores();
		new Start().apagarTodosImoveis();
		
		new Start().inserirClientes();
		new Start().inserirCorretor();
		new Start().inserirImoveis();
	}
	
	public void countCliente(){
		mensagem = "Quantidade de dao de cliente instanciado: " + ClienteDaoImpl.getCount().toString();
	}	
	
	public void countImovel(){
		mensagem = "Quantidade de dao de imovel instanciado: " + ImovelDaoImpl.getCount().toString();
	}	
	
	public void countCorretor(){
		mensagem = "Quantidade de dao de corretor instanciado: " + CorretorDaoImpl.getCount().toString();
	}	
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
