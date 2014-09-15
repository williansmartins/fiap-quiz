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
	public void inserirSomente() {
		dao.insert(getImovel1());
		dao.insert(getImovel2());
	}
	
	public ImovelEntity getImovel1( ) {
		ImovelEntity entity = new ImovelEntity();
		entity.setCidade("Cotia");
		entity.setTitulo("Residencial Ametista");
		entity.setDescricaoCarousel("Descricao carousel");
		entity.setDescricaoCompleta("descricaoCompleta");
		entity.setDescricaoQuadrante("descricaoQuadrante");
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
		entity.setFotos(fotos);		
		entity.setTipo(Tipo.APARTAMENTO);
		entity.setMostrarNoCarousel(true);
		entity.setMostrarNaHome(true);
		return entity;
	}
	
	public ImovelEntity getImovel2( ) {
		ImovelEntity entity = new ImovelEntity();
		entity.setCidade("Jandira");
		entity.setTitulo("Casa dos sonhos");
		entity.setDescricaoCarousel("Descricao carousel - jandira - Descricao carousel - jandira - Descricao carousel - jandira - Descricao carousel - jandira - Descricao carousel - jandira - Descricao carousel - jandira - Descricao carousel - jandira - Descricao carousel");
		entity.setDescricaoCompleta("descricaoCompleta - de jandiradescricaoCompleta - casa de jandiradescricaoCompleta - casa de jandiradescricaoCompleta - casa de jandiradescricaoCompleta - casa de jandiradescricaoCompleta - casa de jandiradescricaoCompleta - casa d");
		entity.setDescricaoQuadrante("descricaoQuadrante - casa de jandiradescricaoQuadrante - casa de jandiradescricaoQuadrante - casa de jandiradescricaoQuadrante - casa de jandiradescricaoQuadrante - casa de ante - casa de jandiradescricaoQuadrante - casa de jandira");
		entity.setDormitorios(2);
		entity.setEndereco("Maria Aparecida Pedrosa, 47, Sagrado Coração, Jandira");
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
		entity.setFotos(fotos);		
		entity.setTipo(Tipo.CASA);
		entity.setMostrarNoCarousel(true);
		entity.setMostrarNaHome(true);
		return entity;
	}

}
