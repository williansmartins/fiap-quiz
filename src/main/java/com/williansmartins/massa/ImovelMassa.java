package com.williansmartins.massa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.ImovelDaoImpl;
import com.williansmartins.entity.FotoEntity;
import com.williansmartins.entity.ImovelEntity;
import com.williansmartins.enums.Fita;
import com.williansmartins.enums.Tipo;

public class ImovelMassa {
	
	JpaGenericDao<ImovelEntity> dao;
	
	public ImovelMassa(){
		dao = new ImovelDaoImpl();
	}

	@Test
	public void inserirImovel() {
		dao.insert(getImovel1());
		dao.insert(getImovel2());
		dao.insert(getImovel3());
		dao.insert(getImovel4());
	}
	
	public ImovelEntity getImovel1( ) {
		ImovelEntity entity = new ImovelEntity();
		entity.setCidade("Cotia");
		entity.setTitulo("Residencial Ametista");
		entity.setDescricaoCompleta("Um apartamento maravilhoso, com vista para o morro do macaco, em frente ao mercado DIA. Próximo de tudo, mercado, padaria, cabelereiro, parque, raposo tavares, escolas, empresas, açougue, hort-fruit, bazar, mercearia, lava-rápidos, posto de saúde, mecânico de autos e de motos, mercado de atacados, etc. Dois quartos, um utilizado como escritório, com 54 m² de puro lazer e diversão, com 1 vaga na garagem, uma área de gourmet para festas e recreações, mini campo de futebol para as crianças. Com acesso aos mais variados comércios da região.");
		entity.setDescricaoQuadrante("Um apartamento maravilhoso, com vista para o morro do macaco, em frente ao mercado DIA. Próximo de tudo, mercado, padaria, cabelereiro, parque, raposo tavares, escolas, empresas, açougue, hort-fruit, bazar");
		entity.setDescricaoCarousel("Um apartamento maravilhoso, com vista para o morro do macaco, em frente ao mercado DIA. Próximo de tudo, mercado, padaria, cabelereiro.");
		entity.setDormitorios(2);
		entity.setEndereco("Amapa, 345, jd rosalina, cotia");
		entity.setFita(Fita.LANCAMENTO);
		entity.setMaps("https://www.google.com/maps/embed?pb=!1m20!1m8!1m3!1d1829.4916250485917!2d-46.8514345!3d-23.4971128!3m2!1i1024!2i768!4f13.1!4m9!1i0!3e6!4m0!4m5!1s0x94cf023b1a960943%3A0xc7c573393bf1f502!2sAlphaville+Comercial%2C+Barueri+-+SP!3m2!1d-23.4970209!2d-46.851323699999995!5e0!3m2!1spt-PT!2sbr!4v1412624406079");
		entity.setMetros(54.4);
		entity.setVagas(1);
		entity.setValor(new BigDecimal("220000"));
		entity.setCaracteristicas("playground;campo de futebol;espaço gourmet; portaria;poucos andares;tranquilidade");		
		entity.setRecursos("recursos próximos;padarias; bazar; academia; restaurantes; pizzarias;açougues;mercados;escolas;pronto-socorro;rodovia próximo;cabelereiros;");		
		List<FotoEntity> fotos = new ArrayList<FotoEntity>();
		fotos.add(new FotoEntity( "ametista-1.jpg" ));
		fotos.add(new FotoEntity( "ametista-2.jpg" ));
		fotos.add(new FotoEntity( "ametista-3.jpg" ));
		fotos.add(new FotoEntity( "ametista-4.jpg" ));
		fotos.add(new FotoEntity( "ametista-5.jpg" ));
		
		entity.setFotoCarousel("ametista-carousel.jpg");
		entity.setFotoQuadrante("ametista-quadrante.jpg");
		
		entity.setFotos(fotos);		
		entity.setTipo(Tipo.APARTAMENTO);
		entity.setMostrarNoCarousel(true);
		entity.setMostrarNaHome(true);
		entity.setTemValor(true);
		entity.setSuites(1);
		entity.setBanheiros(2);
		return entity;
	}
	
	public ImovelEntity getImovel2( ) {
		ImovelEntity entity = new ImovelEntity();
		entity.setCidade("Jandira");
		entity.setTitulo("Grande Família");
		entity.setDescricaoCompleta("Um terreno muito grande, com 3 casas construídas, a primeira casa é a principal com 130 m², as outras 2 possuem 54 m². A localização é ótima, ao lado de Minimercado, próximo à estação de trem, padarias, possui uma escola no mesmo quarteirão, uma visão totalmente panorâmica da área chamada de Chácara dos Padres. Possui 2 vagas de garagem, escritório e banheiro reservado na primeira casa, um jardim lindo, com plantas, árvores frutíferas, hortas de legumes. Uma ampla varanda com mais de 20 m², uma área  para festas, balanço para crianças e muito mais.");
		entity.setDescricaoCarousel("3 casas em uma só, próximo de mercado, estação de trem, padarias, escola no mesmo quarteirão, 2 vagas, jardim, escritório e varanda.");
		entity.setDescricaoQuadrante("Um terreno grande, com 3 casas construídas, a primeira é a principal com 130 m², as outras com 54 m². Próximo de mercado, estação de trem, padarias, escola no mesmo quarteirão, 2 vagas, jardim e varanda.");
		entity.setDormitorios(2);
		entity.setEndereco("Maria Aparecida Pedrosa, 47, Sagrado Coração, Jandira");
		entity.setFita(Fita.OBRAS);
		entity.setMaps("https://www.google.com/maps/embed?pb=!1m20!1m8!1m3!1d1829.4916250485917!2d-46.8514345!3d-23.4971128!3m2!1i1024!2i768!4f13.1!4m9!1i0!3e6!4m0!4m5!1s0x94cf023b1a960943%3A0xc7c573393bf1f502!2sAlphaville+Comercial%2C+Barueri+-+SP!3m2!1d-23.4970209!2d-46.851323699999995!5e0!3m2!1spt-PT!2sbr!4v1412624406079");
		entity.setMetros(500);
		entity.setVagas(2);
		entity.setValor(new BigDecimal("210000"));
		entity.setCaracteristicas("muito espaço; espaço para festas; o	ficina; espaço para escritório; lavanderia externa; grande sacada; balanço; quinta com muito verde; árvores frutíferas; área com gramado");		
		entity.setRecursos("mercado ao lado;açougue;padaria ao lado;estação de trem; ponto de ônibus; escola na mesma rua; cabelereiro; bazar; bares");		
		List<FotoEntity> fotos = new ArrayList<FotoEntity>();
		fotos.add(new FotoEntity("jandira-1.jpg"));
		fotos.add(new FotoEntity("jandira-2.jpg"));
		fotos.add(new FotoEntity("jandira-3.jpg"));
		
		entity.setFotoCarousel("jandira-carousel.jpg");
		entity.setFotoQuadrante("jandira-quadrante.jpg");

		entity.setFotos(fotos);		
		entity.setTipo(Tipo.CASA);
		entity.setMostrarNoCarousel(true);
		entity.setMostrarNaHome(true);
		entity.setTemValor(true);
		entity.setSuites(1);
		entity.setBanheiros(2);
		return entity;
	}
	
	public ImovelEntity getImovel3( ) {
		ImovelEntity entity = new ImovelEntity();
		entity.setCidade("Rio de Janeiro");
		entity.setTitulo("Casa em Ipanema");
		entity.setDescricaoCompleta("Um terreno muito grande, com 3 casas construídas, a primeira casa é a principal com 130 m², as outras 2 possuem 54 m². A localização é ótima, ao lado de Minimercado, próximo à estação de trem, padarias, possui uma escola no mesmo quarteirão, uma visão totalmente panorâmica da área chamada de Chácara dos Padres. Possui 2 vagas de garagem, escritório e banheiro reservado na primeira casa, um jardim lindo, com plantas, árvores frutíferas, hortas de legumes. Uma ampla varanda com mais de 20 m², uma área  para festas, balanço para crianças e muito mais.");
		entity.setDescricaoCarousel("3 casas em uma só, próximo de mercado, estação de trem, padarias, escola no mesmo quarteirão, 2 vagas, jardim, escritório e varanda.");
		entity.setDescricaoQuadrante("Um terreno grande, com 3 casas construídas, a primeira é a principal com 130 m², as outras com 54 m². Próximo de mercado, estação de trem, padarias, escola no mesmo quarteirão, 2 vagas, jardim e varanda.");
		entity.setDormitorios(2);
		entity.setEndereco("Maria Aparecida Pedrosa, 47, Sagrado Coração, Jandira");
		entity.setFita(Fita.PRE);
		entity.setMaps("https://www.google.com/maps/embed?pb=!1m20!1m8!1m3!1d1829.4916250485917!2d-46.8514345!3d-23.4971128!3m2!1i1024!2i768!4f13.1!4m9!1i0!3e6!4m0!4m5!1s0x94cf023b1a960943%3A0xc7c573393bf1f502!2sAlphaville+Comercial%2C+Barueri+-+SP!3m2!1d-23.4970209!2d-46.851323699999995!5e0!3m2!1spt-PT!2sbr!4v1412624406079");
		entity.setMetros(500);
		entity.setVagas(2);
		entity.setValor(new BigDecimal("210000"));
		entity.setCaracteristicas("caracteristica1;caracteristica2;caracteristica3");		
		entity.setRecursos("recurso1;recurso2;recurso3");		
		List<FotoEntity> fotos = new ArrayList<FotoEntity>();
		entity.setFotoCarousel("pacote1-carousel.jpg");
		entity.setFotoQuadrante("pacote1-quadrante.jpg");
		fotos.add(new FotoEntity("pacote1-1.jpg"));
		fotos.add(new FotoEntity("pacote1-2.jpg"));
		fotos.add(new FotoEntity("pacote1-3.jpg"));
		fotos.add(new FotoEntity("pacote1-4.jpg"));
		fotos.add(new FotoEntity("pacote1-5.jpg"));
		fotos.add(new FotoEntity("pacote1-6.jpg"));
		fotos.add(new FotoEntity("pacote1-7.jpg"));
		fotos.add(new FotoEntity("pacote1-8.jpg"));
		fotos.add(new FotoEntity("pacote1-9.jpg"));
		fotos.add(new FotoEntity("pacote1-10.jpg"));
		entity.setFotos(fotos);		
		entity.setTipo(Tipo.CASA);
		entity.setMostrarNoCarousel(true);
		entity.setMostrarNaHome(true);
		entity.setTemValor(true);
		entity.setSuites(1);
		entity.setBanheiros(3);
		return entity;
	}

	public ImovelEntity getImovel4( ) {
		ImovelEntity entity = new ImovelEntity();
		entity.setCidade("Barueri");
		entity.setTitulo("Bela Vista");
		entity.setDescricaoCompleta("Um terreno muito grande, com 3 casas construídas, a primeira casa é a principal com 130 m², as outras 2 possuem 54 m². A localização é ótima, ao lado de Minimercado, próximo à estação de trem, padarias, possui uma escola no mesmo quarteirão, uma visão totalmente panorâmica da área chamada de Chácara dos Padres. Possui 2 vagas de garagem, escritório e banheiro reservado na primeira casa, um jardim lindo, com plantas, árvores frutíferas, hortas de legumes. Uma ampla varanda com mais de 20 m², uma área  para festas, balanço para crianças e muito mais.");
		entity.setDescricaoCarousel("3 casas em uma só, próximo de mercado, estação de trem, padarias, escola no mesmo quarteirão, 2 vagas, jardim, escritório e varanda.");
		entity.setDescricaoQuadrante("Um terreno grande, com 3 casas construídas, a primeira é a principal com 130 m², as outras com 54 m². Próximo de mercado, estação de trem, padarias, escola no mesmo quarteirão, 2 vagas, jardim e varanda.");
		entity.setDormitorios(2);
		entity.setEndereco("Maria Aparecida Pedrosa, 47, Sagrado Coração, Jandira");
		entity.setFita(Fita.PRONTO);
		entity.setMaps("https://www.google.com/maps/embed?pb=!1m20!1m8!1m3!1d1829.4916250485917!2d-46.8514345!3d-23.4971128!3m2!1i1024!2i768!4f13.1!4m9!1i0!3e6!4m0!4m5!1s0x94cf023b1a960943%3A0xc7c573393bf1f502!2sAlphaville+Comercial%2C+Barueri+-+SP!3m2!1d-23.4970209!2d-46.851323699999995!5e0!3m2!1spt-PT!2sbr!4v1412624406079");
		entity.setMetros(500);
		entity.setVagas(2);
		entity.setCaracteristicas("caracteristica1;caracteristica2;caracteristica3");		
		entity.setRecursos("recurso1;recurso2;recurso3");		
		List<FotoEntity> fotos = new ArrayList<FotoEntity>();
		entity.setFotoCarousel("pacote2-carousel.jpg");
		entity.setFotoQuadrante("pacote2-quadrante.jpg");
		fotos.add(new FotoEntity("pacote2-1.jpg"));
		fotos.add(new FotoEntity("pacote2-2.jpg"));
		fotos.add(new FotoEntity("pacote2-3.jpg"));
		fotos.add(new FotoEntity("pacote2-4.jpg"));
		fotos.add(new FotoEntity("pacote2-5.jpg"));
		fotos.add(new FotoEntity("pacote2-6.jpg"));
		fotos.add(new FotoEntity("pacote2-7.jpg"));
		fotos.add(new FotoEntity("pacote2-8.jpg"));
		fotos.add(new FotoEntity("pacote2-9.jpg"));
		fotos.add(new FotoEntity("pacote2-10.jpg"));
		fotos.add(new FotoEntity("pacote2-11.jpg"));
		fotos.add(new FotoEntity("pacote2-12.jpg"));
		fotos.add(new FotoEntity("pacote2-13.jpg"));
		fotos.add(new FotoEntity("pacote2-14.jpg"));
		fotos.add(new FotoEntity("pacote2-15.jpg"));
		fotos.add(new FotoEntity("pacote2-16.jpg"));
		entity.setFotos(fotos);		
		entity.setTipo(Tipo.CASA);
		entity.setMostrarNoCarousel(true);
		entity.setMostrarNaHome(true);
		entity.setTemValor(false);
		entity.setSuites(2);
		entity.setBanheiros(4);
		return entity;
	}

	public void removerImovel() {
		for (ImovelEntity o : dao.findAll()) {
			dao.delete( o.getId() );
		}
	}
	
	public void testeDeStress() throws Exception {
		List<ImovelEntity> listaEntities = new ArrayList<ImovelEntity>();
		
		// Inserir 10 entities
		for (int cont = 0; cont < 200; cont++) {
			ImovelEntity entityMockada1 = new ImovelEntity();
			entityMockada1 = new ImovelMassa().getImovel1();
			listaEntities.add(entityMockada1);
		}
		
		dao.insertAll(listaEntities);
		
		// Remover as entities
//		for (ImovelEntity entity : listaEntities) {
//			dao.delete(entity.getId());
//		}
		
	}

}
