package com.williansmartins.massa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.ImovelDaoImpl;
import com.williansmartins.entity.FotoEntity;
import com.williansmartins.entity.ImovelEntity;
import com.williansmartins.entity.Tipo;

public class ImovelMassa {
	
	JpaGenericDao<ImovelEntity> dao = new ImovelDaoImpl();

	@Test
	public void inserirImovel() {
		dao.insert(getImovel1());
		dao.insert(getImovel2());
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
		entity.setFita("sale");
		entity.setFotoCarousel("carousel-cotia.jpg");
		entity.setMaps("url maps");
		entity.setMetros(54.4);
		entity.setVagas(1);
		entity.setValor(new BigDecimal("150000"));
		entity.setCaracteristicas("caracteristica1;caracteristica2;caracteristica3;");		
		entity.setRecursos("recurso1;recurso2;recurso3;");		
		List<FotoEntity> fotos = new ArrayList<FotoEntity>();
		fotos.add(new FotoEntity("grande1.jpg", "thumb1.jpg"));
		fotos.add(new FotoEntity("grande2.jpg", "thumb2.jpg"));
		fotos.add(new FotoEntity("grande3.jpg", "thumb3.jpg"));
		entity.setCarousel("carousel-cotia.jpg");
		entity.setFotos(fotos);		
		entity.setTipo(Tipo.APARTAMENTO);
		entity.setMostrarNoCarousel(true);
		entity.setMostrarNaHome(true);
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
		entity.setEndereco("Maria Aparecida Pedrosa, 47, Sagrado Cora�‹o, Jandira");
		entity.setFita("rent");
		entity.setFotoCarousel("carousel-jandira.jpg");
		entity.setMaps("url maps jandira - url maps url maps url maps url maps url maps url maps url maps url maps url maps ");
		entity.setMetros(500);
		entity.setVagas(2);
		entity.setValor(new BigDecimal("210000"));
		entity.setCaracteristicas("caracteristica1;caracteristica2;caracteristica3;");		
		entity.setRecursos("recurso1;recurso2;recurso3;");		
		List<FotoEntity> fotos = new ArrayList<FotoEntity>();
		fotos.add(new FotoEntity("grande-jandira-1.jpg", "thumb-jandira-1.jpg"));
		fotos.add(new FotoEntity("grande-jandira-2.jpg", "thumb-jandira-2.jpg"));
		fotos.add(new FotoEntity("grande-jandira-3.jpg", "thumb-jandira-3.jpg"));
		entity.setCarousel("carousel-jandira.jpg");
		entity.setFotos(fotos);		
		entity.setTipo(Tipo.CASA);
		entity.setMostrarNoCarousel(true);
		entity.setMostrarNaHome(true);
		return entity;
	}

	public void removerImovel() {
		for (ImovelEntity o : dao.findAll()) {
			dao.delete( o.getId() );
		}
	}

}
