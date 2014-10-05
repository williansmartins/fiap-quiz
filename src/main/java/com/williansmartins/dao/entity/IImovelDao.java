package com.williansmartins.dao.entity;

import java.util.List;

import com.williansmartins.dao.Dao;
import com.williansmartins.entity.ImovelEntity;

public interface IImovelDao extends Dao<ImovelEntity>{
	List<String> findCityes();
	List<ImovelEntity> findCarousel();
	List<ImovelEntity> buscarImoveisQueApresentamNaHome();
}