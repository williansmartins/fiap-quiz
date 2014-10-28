package com.williansmartins.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="user")
public class UserEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	Integer id;
	private String nome;
	private String cpf;
	private Time tempo;
	@OneToMany(targetEntity = RespostaEntity.class, cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
	List<RespostaEntity> respostas;
	
	public UserEntity(){
		
	}
	
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<RespostaEntity> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaEntity> respostas) {
		this.respostas = respostas;
	}

	public Time getTempo() {
		return tempo;
	}

	public void setTempo(Time tempo) {
		this.tempo = tempo;
	}

	
}
