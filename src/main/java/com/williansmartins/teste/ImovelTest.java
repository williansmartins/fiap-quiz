package com.williansmartins.teste;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.ImovelDaoImpl;
import com.williansmartins.entity.ImovelEntity;

public class ImovelTest {
	JpaGenericDao<ImovelEntity> dao = new ImovelDaoImpl();
	
	@Test
	public void inserirObjeto() {
		ImovelEntity entityMockada = new ImovelEntity();
		entityMockada = popularEntity(entityMockada);
		
		dao.insert(entityMockada);
		Assert.assertNotNull(entityMockada.getId());
	}
	
	@Test
	public void excluirPedido() {
		ImovelEntity entityMockada = new ImovelEntity();
		entityMockada = popularEntity(entityMockada);
		
		dao.insert(entityMockada);
		dao.delete(entityMockada.getId());
		ImovelEntity entityDoBanco = dao.findById(entityMockada.getId());
		
		Assert.assertNull(entityDoBanco);
	}
	
	@Test
	public void listarPedidos() {
		List<ImovelEntity> listaEntities = new ArrayList<ImovelEntity>();
		
		for  (int cont = 0; cont < 10; cont++) {
			ImovelEntity entityMockada = new ImovelEntity();
			entityMockada = popularEntity(entityMockada);
			listaEntities.add(entityMockada);
		}
		
		dao.insertAll(listaEntities);
		
		List<ImovelEntity> lista = dao.findAll();
		
		Assert.assertTrue( lista.size() >1 );
	}
	
	public ImovelEntity popularEntity(ImovelEntity entity){
		
		entity.setCidade("Cotia");
		entity.setTitulo("Residencial Ametista");
		entity.setDescricaoCarousel("Descricao carousel");
		entity.setDescricaoCompleta("descricaoCompleta");
		entity.setDescricaoQuadrante("descricaoQuadrante");
		entity.setDormitorios(2);
		entity.setEndereco("Amapa, 345, jd rosalina, cotia");
		entity.setFita("sale");
		entity.setFotoCarousel("imagem1.jpg");
		entity.setMaps("url maps");
		entity.setMetros(54.4);
		entity.setVagas(1);
		entity.setValor(new BigDecimal("150000"));
		
		return entity;
	}
}
