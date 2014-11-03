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
	
	public UserVO(String nome, String cpf, Date created, String email,
			String telefone, boolean aluno, int acertos) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.created = created;
		this.email = email;
		this.telefone = telefone;
		this.aluno = aluno;
		this.acertos = acertos;
	}

	public UserVO() {
		super();
	}
	
}
