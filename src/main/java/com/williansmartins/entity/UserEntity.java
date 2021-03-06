package com.williansmartins.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

@Entity(name="user")
public class UserEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	Integer id;
	private String nome;
	private String cpf;
	private Date created;
	@OneToMany(targetEntity = RespostaEntity.class, cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
	List<RespostaEntity> respostas;
	String email;
	String telefone;
	boolean aluno;
	
	public UserEntity(){
	}

	@PrePersist
	protected void onCreate() {
		created = new Date();
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
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

	public boolean isAluno() {
		return aluno;
	}

	public void setAluno(boolean aluno) {
		this.aluno = aluno;
	}

	
}
