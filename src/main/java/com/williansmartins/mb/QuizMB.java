package com.williansmartins.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.williansmartins.dao.entity.QuestaoDaoImpl;
import com.williansmartins.dao.entity.UserDaoImpl;
import com.williansmartins.entity.QuestaoEntity;
import com.williansmartins.entity.UserEntity;

@ManagedBean(name="quizMB")
@SessionScoped
public class QuizMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private QuestaoEntity questaoAtual;
	private QuestaoDaoImpl daoQuestao;
	private UserDaoImpl daoUser;
	private List<QuestaoEntity> listaDeQuestoes;
	private int indiceDaQuestao;
	private UserEntity userBean;
	private final String SENHA_MASTER = "secreta";
	private String senhaDigitada;
	
	public QuizMB(){
		daoQuestao = new QuestaoDaoImpl();
		questaoAtual = new QuestaoEntity();
		listaDeQuestoes = daoQuestao.findAll();
	}
	
	public String salvar(){
		if(questaoAtual.getId() == null){
			daoQuestao.insert(questaoAtual);
		}else{
			daoQuestao.update(questaoAtual);
		}
		questaoAtual = new QuestaoEntity();
		listaDeQuestoes = daoQuestao.findAll();
		return "admin-clientes.xhtml?faces-redirect=true";
	}
	
	public String salvarSomente(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		indiceDaQuestao = Integer.parseInt( request.getParameter("modal-cliente:imovel_id") );
		//entity.setInteresse(request.getParameter("modal-cliente:interesse") );
		daoQuestao.insert(questaoAtual);
		questaoAtual = new QuestaoEntity();
		return "imovel.xhtml?imovel_id=" + indiceDaQuestao + "&faces-redirect=true";
	}
	
	////// GETTERS AND SETTERS ///////////////
	/////////////////////////////////////////
	
	public QuestaoEntity getEntity() {
		return questaoAtual;
	}

	public void setEntity(QuestaoEntity entity) {
		this.questaoAtual = entity;
	}

	public List<QuestaoEntity> getLista() {
		return listaDeQuestoes;
	}

	public void setLista(List<QuestaoEntity> lista) {
		this.listaDeQuestoes = lista;
	}

	public int getIndiceDaQuestao() {
		return indiceDaQuestao;
	}

	public void setIndiceDaQuestao(int indiceDaQuestao) {
		this.indiceDaQuestao = indiceDaQuestao;
	}

	public QuestaoEntity getQuestaoAtual() {
		return questaoAtual;
	}

	public void setQuestaoAtual(QuestaoEntity questaoAtual) {
		this.questaoAtual = questaoAtual;
	}

	public List<QuestaoEntity> getListaDeQuestoes() {
		return listaDeQuestoes;
	}

	public void setListaDeQuestoes(List<QuestaoEntity> listaDeQuestoes) {
		this.listaDeQuestoes = listaDeQuestoes;
	}

	public UserEntity getUserBean() {
		return userBean;
	}

	public void setUserBean(UserEntity userBean) {
		this.userBean = userBean;
	}

	public String getSenhaDigitada() {
		return senhaDigitada;
	}

	public void setSenhaDigitada(String senhaDigitada) {
		this.senhaDigitada = senhaDigitada;
	}

	
}
