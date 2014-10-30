package com.williansmartins.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="questao")
public class QuestaoEntity implements Serializable {

	@Id @GeneratedValue
	Integer id;
	private static final long serialVersionUID = 83908783713350043L;
	@Column(length = 558)
	private String pergunta;
	private String respostaA;
	private String respostaB;
	private String respostaC;
	private String respostaD;
	private String respostaE;
	private char correta;
	
	public QuestaoEntity() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getRespostaA() {
		return respostaA;
	}

	public void setRespostaA(String respostaA) {
		this.respostaA = respostaA;
	}

	public String getRespostaB() {
		return respostaB;
	}

	public void setRespostaB(String respostaB) {
		this.respostaB = respostaB;
	}

	public String getRespostaC() {
		return respostaC;
	}

	public void setRespostaC(String respostaC) {
		this.respostaC = respostaC;
	}

	public String getRespostaD() {
		return respostaD;
	}

	public void setRespostaD(String respostaD) {
		this.respostaD = respostaD;
	}

	public String getRespostaE() {
		return respostaE;
	}

	public void setRespostaE(String respostaE) {
		this.respostaE = respostaE;
	}

	public char getCorreta() {
		return correta;
	}

	public void setCorreta(char correta) {
		this.correta = correta;
	}
	
}
