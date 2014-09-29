package com.williansmartins.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="cliente")
public class ClienteEntity implements Serializable {
	
	private static final long serialVersionUID = 83908783713350043L;
	
	@Id @GeneratedValue
	Integer id;
	
	String nome;
	String email;
	String telefone;
	String celular;
	String interesse;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public String getInteresse() {
		return interesse;
	}
	public void setInteresse(String interesse) {
		this.interesse = interesse;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
}
