package com.williansmartins.dao.entity;

import com.williansmartins.dao.Dao;
import com.williansmartins.entity.UserEntity;

public interface IUserDao extends Dao<UserEntity>{
	public boolean existeUsuario(UserEntity user);
}