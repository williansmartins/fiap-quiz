package com.williansmartins.vo;


public class QuestaoVO {

	private Integer id;
	private String pergunta;
	private String respostaA;
	private String respostaB;
	private String respostaC;
	private String respostaD;
	private String respostaE;
	private char correta;
	
	public QuestaoVO(Integer id, String pergunta, String respostaA,
			String respostaB, String respostaC, String respostaD,
			String respostaE, char correta) {
		super();
		this.id = id;
		this.pergunta = pergunta;
		this.respostaA = respostaA;
		this.respostaB = respostaB;
		this.respostaC = respostaC;
		this.respostaD = respostaD;
		this.respostaE = respostaE;
		this.correta = correta;
	}
	
	public QuestaoVO() {
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
