package com.williansmartins.massa;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.ClienteDaoImpl;
import com.williansmartins.entity.ClienteEntity;

public class ClienteMassa {
	
	JpaGenericDao<ClienteEntity> dao = new ClienteDaoImpl();

	public void inserirUm() {
		ClienteEntity entityMockada = new ClienteEntity();
		entityMockada = popularEntity(entityMockada);
		dao.insert(entityMockada);
	}
	
	public ClienteEntity popularEntity(ClienteEntity entity){
		entity.setNome("Cliente1");
		entity.setCelular("(11) 993-650-220");
		entity.setTelefone("(11) 4148-4583");
		entity.setEmail("cliente1@gmail.com");
		entity.setInteresse("imovel x");
		return entity;
	}

	public void removerTudo() {
		for (ClienteEntity o : dao.findAll()) {
			dao.delete( o.getId() );
		}
	}
}
