package com.williansmartins.teste;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.ImovelDaoImpl;
import com.williansmartins.entity.ImovelEntity;

@SuppressWarnings("deprecation")
public class ImovelTest {
	JpaGenericDao<ImovelEntity> dao = new ImovelDaoImpl();
	
	public void inserirSomente() {
		ImovelEntity entityMockada = new ImovelEntity();
		entityMockada = popularEntity(entityMockada);
		dao.insert(entityMockada);
	}
	
	@Test
	public void inserirERemoverEntity() {
		ImovelEntity entityMockada = new ImovelEntity();
		entityMockada = popularEntity(entityMockada);
		
		dao.insert(entityMockada);
		
		Assert.assertNotNull( dao.findById(entityMockada.getId()) );
		
		dao.delete( entityMockada.getId() );
		Assert.assertNull( dao.findById(entityMockada.getId()) );
		
	}
	
	@Test
	public void listarEntities() {
		List<ImovelEntity> listaEntities = new ArrayList<ImovelEntity>();
		
		//Inserir 10 entities
		for  (int cont = 0; cont < 10; cont++) {
			ImovelEntity entityMockada = new ImovelEntity();
			entityMockada = popularEntity(entityMockada);
			listaEntities.add(entityMockada);
		}
		
		dao.insertAll(listaEntities);
		
		//Testar se inseriu as 10
		Assert.assertTrue( dao.findAll().size() > 9 );
		Assert.assertNotNull( dao.findById(listaEntities.get(0).getId())  );
		Assert.assertNotNull( dao.findById(listaEntities.get(9).getId())  );
		
		//Remover as entities
		for (ImovelEntity entity : listaEntities) {
			dao.delete(entity.getId());
		}
		
		//Verificar se elas realmente n�o est�o no banco
		Assert.assertNull( dao.findById(listaEntities.get(0).getId())  );
		Assert.assertNull( dao.findById(listaEntities.get(9).getId())  );
		
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