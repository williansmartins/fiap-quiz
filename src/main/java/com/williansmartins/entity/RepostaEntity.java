package com.williansmartins.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="resposta")
public class RepostaEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	Integer id;
	private int numero;
	private String respondeu;
	private String acertou;
	
	public RepostaEntity(){
		
	}
	
	public RepostaEntity(int numero, String respondeu, String acertou) {
		super();
		this.numero = numero;
		this.respondeu = respondeu;
		this.acertou = acertou;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRespondeu() {
		return respondeu;
	}

	public void setRespondeu(String respondeu) {
		this.respondeu = respondeu;
	}

	public String getAcertou() {
		return acertou;
	}

	public void setAcertou(String acertou) {
		this.acertou = acertou;
	}

}