package com.williansmartins.vo;

import java.util.Date;

public class UserVO {

	String nome;
	String cpf;
	Date created;
	String email;
	String telefone;
	boolean aluno;
	int acertos;
	int erros;
	int saldo;
	
	public UserVO(String nome, String cpf, Date created, String email,
			String telefone, boolean aluno, int acertos, int erros, int saldo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.created = created;
		this.email = email;
		this.telefone = telefone;
		this.aluno = aluno;
		this.acertos = acertos;
		this.erros = erros;
		this.saldo = saldo;
	}

	public UserVO() {
		super();
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

	public int getAcertos() {
		return acertos;
	}

	public void setAcertos(int acertos) {
		this.acertos = acertos;
	}

	public int getErros() {
		return erros;
	}

	public void setErros(int erros) {
		this.erros = erros;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	
}
