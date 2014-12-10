package com.williansmartins.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.core.context.SecurityContextHolder;

import com.williansmartins.dao.UserDAOJDBC;
import com.williansmartins.dao.entity.QuestaoDaoImpl;
import com.williansmartins.dao.entity.UserDaoImpl;
import com.williansmartins.entity.RespostaEntity;
import com.williansmartins.entity.UserEntity;
import com.williansmartins.util.EmailValidator;
import com.williansmartins.util.ValidarCpf;
import com.williansmartins.vo.QuestaoVO;
import com.williansmartins.vo.UserVO;

@ManagedBean(name="quizMB")
@SessionScoped
public class QuizMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private QuestaoVO questaoAtual;
	private QuestaoDaoImpl daoQuestao;
	private UserDaoImpl daoUser;
	private List<QuestaoVO> listaDeQuestoes;
	private int indiceDaQuestao;
	private UserEntity user;
	private String senhaDigitada;
	private String chute;
	private List<RespostaEntity> respostas;
	private List<UserVO> competidores;
	
	public QuizMB(){
		daoQuestao = new QuestaoDaoImpl();
		daoUser = new UserDaoImpl();
		//listaDeQuestoes = daoQuestao.findAll();
		//competidores = new DAOJDBC().buscarCompetidores();
		buscarQuestoes();
		indiceDaQuestao = 0;
		questaoAtual = listaDeQuestoes.get( indiceDaQuestao );
		user = new UserEntity();
		respostas = new ArrayList<RespostaEntity>();
		user.setRespostas(new ArrayList<RespostaEntity>() );
	}
	
	public void popularCompetidores(){
		competidores = new UserDAOJDBC().buscarCompetidores();
	}
	
	public void buscarQuestoes(  ){
		String tema = "html";
		listaDeQuestoes = daoQuestao.buscarPorTema( tema );
	}
	
	public String logout() throws IOException{
        SecurityContextHolder.clearContext();
        user = new UserEntity();
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml.xhtml?faces-redirect=true");
        return "login.xhtml?faces-redirect=true";
    }
	
	public void enviar() throws IOException{
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
			reiniciar();
			FacesContext.getCurrentInstance().getExternalContext().redirect("admin-ultima.xhtml?faces-redirect=true");
		}else{
			System.out.println("Tem mais");
			questaoAtual = listaDeQuestoes.get( indiceDaQuestao );
		}
	}
	
	public void pular() throws IOException{
		RespostaEntity resposta = new RespostaEntity();
		resposta.setAcertou("nao");
		resposta.setNumero(questaoAtual.getId());
		resposta.setRespondeu("-");
		respostas.add(resposta);
		
		if( indiceDaQuestao++ >= listaDeQuestoes.size()-1 ){
			System.out.println("chegou ao fim");
			reiniciar();
			FacesContext.getCurrentInstance().getExternalContext().redirect("admin-ultima.xhtml?faces-redirect=true");
		}else{
			System.out.println("Tem mais");
			questaoAtual = listaDeQuestoes.get( indiceDaQuestao );
		}
	}
	
	public String reiniciar(){
		user.setRespostas(respostas);
		daoUser.insert(user);
		indiceDaQuestao = 0;
		user = new UserEntity();
		respostas = new ArrayList<RespostaEntity>();
		user.setRespostas(new ArrayList<RespostaEntity>() );
		return "login.xhtml?faces-redirect=true";
	}

//Em caso de falha em uma das versões operacionais, o sistema passa a ex	
	public String concluir(){
		indiceDaQuestao = 0;
		user = new UserEntity();
		respostas = new ArrayList<RespostaEntity>();
		user.setRespostas(new ArrayList<RespostaEntity>() );
		return "login.xhtml?faces-redirect=true";
	}
	
	public String entrar(){
		user.setCpf( user.getCpf().replace("-", "").replace(".", "") );
		//verificar se existe usuário - PELO CPF
		if( false ){
			return "admin-inicio.xhtml?faces-redirect=true&error=true&mensagem=CPF ja utilizado!";
		}else{
			//verificar se o cpf é válido
			if( true ){
				if(new EmailValidator().validate(user.getEmail())){
					indiceDaQuestao = 0;
					Collections.shuffle(listaDeQuestoes);
					questaoAtual = listaDeQuestoes.get( indiceDaQuestao );
					return "admin-questao.xhtml?faces-redirect=true";
				}else{
					return "admin-inicio.xhtml?faces-redirect=true&error=true&mensagem=Email invalido!";
				}
			}else{
				return "admin-inicio.xhtml?faces-redirect=true&error=true&mensagem=CPF invalido!";
			}
		}

		
	}
	
	////// GETTERS AND SETTERS ///////////////
	/////////////////////////////////////////
	


	public List<QuestaoVO> getLista() {
		return listaDeQuestoes;
	}

	public void setLista(List<QuestaoVO> lista) {
		this.listaDeQuestoes = lista;
	}

	public int getIndiceDaQuestao() {
		return indiceDaQuestao;
	}

	public void setIndiceDaQuestao(int indiceDaQuestao) {
		this.indiceDaQuestao = indiceDaQuestao;
	}

	public QuestaoVO getQuestaoAtual() {
		return questaoAtual;
	}

	public void setQuestaoAtual(QuestaoVO questaoAtual) {
		this.questaoAtual = questaoAtual;
	}

	public List<QuestaoVO> getListaDeQuestoes() {
		return listaDeQuestoes;
	}

	public void setListaDeQuestoes(List<QuestaoVO> listaDeQuestoes) {
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

	public List<UserVO> getCompetidores() {
		return competidores;
	}

	public void setCompetidores(List<UserVO> competidores) {
		this.competidores = competidores;
	}

	
}
