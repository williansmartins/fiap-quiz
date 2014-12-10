package com.williansmartins.dao.entity;

import java.io.Serializable;
import java.util.List;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.QuestaoDAOJDBC;
import com.williansmartins.entity.QuestaoEntity;
import com.williansmartins.vo.QuestaoVO;

public class QuestaoDaoImpl extends JpaGenericDao<QuestaoEntity> implements IQuestaoDao, Serializable{

	private QuestaoDAOJDBC jdbc;
	private static final long serialVersionUID = 1L;

	public List<QuestaoVO> buscarPorTema(String tema) {
		jdbc = new QuestaoDAOJDBC();
		List<QuestaoVO> lista = jdbc.buscarPorAssunto( tema );
		return lista;
	}
}

