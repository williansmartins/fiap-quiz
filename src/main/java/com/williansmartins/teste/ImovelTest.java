package com.williansmartins.teste;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.ImovelDaoImpl;
import com.williansmartins.entity.FotoEntity;
import com.williansmartins.entity.ImovelEntity;
import com.williansmartins.entity.Tipo;

@SuppressWarnings("deprecation")
public class ImovelTest {
	JpaGenericDao<ImovelEntity> dao = new ImovelDaoImpl();

	@Test
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

		ImovelEntity entityBanco = dao.findById(entityMockada.getId());
		
		//Testar se inseriu mesmo
		Assert.assertNotNull(entityBanco );
		
		//Testar se as caracteristicas foram inseridas
		Assert.assertTrue(  entityBanco.getCaracteristicas().size() == 3 );
		Assert.assertFalse(  entityBanco.getCaracteristicas().size() == 2 );
		Assert.assertFalse(  entityBanco.getCaracteristicas().size() == 4 );
		
		//Testar se as fotos foram inseridas
		Assert.assertEquals(true, entityBanco.getFotos().size() == 3);
		Assert.assertEquals(false, entityBanco.getFotos().size() == 2);
		Assert.assertEquals(false, entityBanco.getFotos().size() == 4);

		//Testar se removeu a entidade	
		dao.delete(entityMockada.getId());
		Assert.assertNull(dao.findById(entityMockada.getId()));

	}

	@Test
	public void listarEntities() {
		List<ImovelEntity> listaEntities = new ArrayList<ImovelEntity>();

		// Inserir 10 entities
		for (int cont = 0; cont < 10; cont++) {
			ImovelEntity entityMockada = new ImovelEntity();
			entityMockada = popularEntity(entityMockada);
			listaEntities.add(entityMockada);
		}

		dao.insertAll(listaEntities);

		// Testar se inseriu as 10
		Assert.assertTrue(dao.findAll().size() > 9);
		Assert.assertNotNull(dao.findById(listaEntities.get(0).getId()));
		Assert.assertNotNull(dao.findById(listaEntities.get(9).getId()));

		// Remover as entities
		for (ImovelEntity entity : listaEntities) {
			dao.delete(entity.getId());
		}

		// Verificar se elas realmente não estão no banco
		Assert.assertNull(dao.findById(listaEntities.get(0).getId()));
		Assert.assertNull(dao.findById(listaEntities.get(9).getId()));

	}

	public ImovelEntity popularEntity(ImovelEntity entity) {

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

		List<String> caracteristicas = new ArrayList<String>();
		caracteristicas.add("caracteristica1");
		caracteristicas.add("caracteristica2");
		caracteristicas.add("caracteristica3");
		entity.setCaracteristicas(caracteristicas);
		
		List<FotoEntity> fotos = new ArrayList<FotoEntity>();
		fotos.add(new FotoEntity("grande1.jpg", "thumb1.jpg"));
		fotos.add(new FotoEntity("grande2.jpg", "thumb2.jpg"));
		fotos.add(new FotoEntity("grande3.jpg", "thumb3.jpg"));
		entity.setFotos(fotos);
		
		entity.setTipo(Tipo.APARTAMENTO);

		return entity;
	}

	@Test
	public void buscarPorTudo( ){
		ImovelEntity entityMockada = new ImovelEntity();
		List<ImovelEntity> lista;
				
		entityMockada = popularEntity( entityMockada );

		dao.insert( entityMockada );

		ImovelEntity entityBanco = dao.findById( entityMockada.getId() );
		
		//Testar se inseriu mesmo
		Assert.assertNotNull( entityBanco );
		
		//Teste passa porque existe
		lista = dao.find(Tipo.APARTAMENTO, "cotia", new BigDecimal(120000), new BigDecimal(160000));
		Assert.assertTrue( lista.size() > 0 );
		
		//Teste passa raspando no preço
		lista = dao.find(Tipo.APARTAMENTO, "cotia", new BigDecimal(150000), new BigDecimal(150000));
		Assert.assertTrue( lista.size() > 0 );
		
		//Testa falha por tipo 
		lista = dao.find(Tipo.CASA, "cotia", new BigDecimal(120000), new BigDecimal(160000) );
		Assert.assertNull( lista );
		
		//Testa falha por cidade 
		lista = dao.find(Tipo.APARTAMENTO, "jaguariuna", new BigDecimal(120000), new BigDecimal(160000) );
		Assert.assertNull( lista );
		
		//Testa falha por preco
		lista = dao.find(Tipo.APARTAMENTO, "cotia", new BigDecimal(120000), new BigDecimal(100000) );
		Assert.assertNull( lista );
		
		//Testa passa com cidade nulla
		lista = dao.find(Tipo.APARTAMENTO, "", new BigDecimal(120000), new BigDecimal(150000) );
		Assert.assertTrue( lista.size() > 0 );
		
		//Testa passa com cidade nulla
		lista = dao.find(Tipo.APARTAMENTO, null, new BigDecimal(120000), new BigDecimal(150000) );
		Assert.assertTrue( lista.size() > 0 );
		
		//Testa passa com tipo nulla
		lista = dao.find( null, "cotia", new BigDecimal(120000), new BigDecimal(150000) );
		Assert.assertTrue( lista.size() > 0 );
		
		//Testa passa com tipo e cidade forem null
		lista = dao.find( null, null, new BigDecimal(120000), new BigDecimal(150000) );
		Assert.assertTrue( lista.size() > 0 );
		
		//Testar se removeu a entidade	
		dao.delete(entityMockada.getId());
		Assert.assertNull( dao.findById(entityMockada.getId()) );
	}
	
	@Test
	public void buscarPorTitulo( ){
		ImovelEntity entityMockada = new ImovelEntity();
		List<ImovelEntity> lista;
		
		entityMockada = popularEntity( entityMockada );
		
		dao.insert( entityMockada );
		
		ImovelEntity entityBanco = dao.findById( entityMockada.getId() );
		
		//Testar se inseriu mesmo
		Assert.assertNotNull( entityBanco );
		
		//Testar se existe encontra o item procurado
		lista = dao.find("Ametista");
		Assert.assertTrue( lista.size() > 0 );
		
		//Testar inverso
		lista = dao.find("asdfg" );
		Assert.assertNull( lista );
		
		//Testar se removeu a entidade	
		dao.delete(entityMockada.getId());
		Assert.assertNull( dao.findById(entityMockada.getId()) );
	}
}