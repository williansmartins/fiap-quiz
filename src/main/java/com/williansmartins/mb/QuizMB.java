package com.williansmartins.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.context.SecurityContextHolder;

import com.williansmartins.dao.entity.QuestaoDaoImpl;
import com.williansmartins.dao.entity.UserDaoImpl;
import com.williansmartins.entity.QuestaoEntity;
import com.williansmartins.entity.RespostaEntity;
import com.williansmartins.entity.UserEntity;
import com.williansmartins.util.ValidarCpf;

@ManagedBean(name="quizMB")
@SessionScoped
public class QuizMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private QuestaoEntity questaoAtual;
	private QuestaoDaoImpl daoQuestao;
	private UserDaoImpl daoUser;
	private List<QuestaoEntity> listaDeQuestoes;
	private int indiceDaQuestao;
	private UserEntity user;
	private String senhaDigitada;
	private String chute;
	private List<RespostaEntity> respostas = new ArrayList<RespostaEntity>();
	
	public QuizMB(){
		daoQuestao = new QuestaoDaoImpl();
		daoUser = new UserDaoImpl();
		listaDeQuestoes = daoQuestao.findAll();
		indiceDaQuestao = 0;
		questaoAtual = listaDeQuestoes.get( indiceDaQuestao );
		user = new UserEntity();
		user.setRespostas(new ArrayList<RespostaEntity>() );
	}
	
	public String logout(){
        SecurityContextHolder.clearContext();
        user = new UserEntity();
        return "login.xhtml?faces-redirect=true";
    }
	
	public String enviar(){
		RespostaEntity resposta = new RespostaEntity();
		
		if( chute.charAt(0) == questaoAtual.getCorreta()  ){
			System.out.println("acertou");
			resposta.setAcertou("sim");
		}else{
			System.out.println("errou");
			resposta.setAcertou("não");
		}

		resposta.setNumero(questaoAtual.getId());
		resposta.setRespondeu(chute);
		respostas.add(resposta);
		
		if( indiceDaQuestao++ >= listaDeQuestoes.size()-1 ){
			System.out.println("chegou ao fim");
			//se chegou ao fim, pega todas as respostas e insere no banco
			user.setRespostas(respostas);
			daoUser.insert(user);
			
			return "admin-ultima.xhtml?faces-redirect=true";
		}else{
			System.out.println("Tem mais");
			questaoAtual = listaDeQuestoes.get( indiceDaQuestao );
			return "";
		}
	}
	
	public String pular(){
		if( indiceDaQuestao++ >= listaDeQuestoes.size()-1 ){
			System.out.println("chegou ao fim");
			return "admin-ultima.xhtml?faces-redirect=true";
		}else{
			System.out.println("Tem mais");
			questaoAtual = listaDeQuestoes.get( indiceDaQuestao );
			return "";
		}
	}
	
	public String reiniciar(){
		indiceDaQuestao = 0;
		daoUser.insert(user);
		user = new UserEntity();
		return "login.xhtml?faces-redirect=true";
	}
	
	public String entrar(){
		user.setCpf( user.getCpf().replace("-", "").replace(".", "") );
		//verificar se existe usuário
		if( daoUser.existeUsuario(user) ){
			return "admin-inicio.xhtml?faces-redirect=true&error=true&mensagem=CPF ja utilizado!";
		}else{
			//verificar se o cpf é válido
			if( true ){
//				if( new ValidarCpf().validarCpf( user.getCpf() ) ){
				return "admin-questao.xhtml?faces-redirect=true";
			}else{
				return "admin-inicio.xhtml?faces-redirect=true&error=true&mensagem=CPF invalido!";
			}
		}

		
	}
	
	//context.addMessage(null, new FacesMessage("Não te conheço"));
	//FacesContext context = FacesContext.getCurrentInstance();
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getSenhaDigitada() {
		return senhaDigitada;
	}

	public void setSenhaDigitada(String senhaDigitada) {
		this.senhaDigitada = senhaDigitada;
	}

	public String getChute() {
		return chute;
	}

	public void setChute(String chute) {
		this.chute = chute;
	}

	
}
