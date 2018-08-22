package com.project.repository.impl;

import java.io.Serializable;

import com.project.entity.User;
import com.project.repository.GenericDaoRepositoryImpl;
import com.project.repository.UserRepository;

public class UserRepositoryImpl extends GenericDaoRepositoryImpl<User,Long> implements UserRepository, Serializable{

	private static final long serialVersionUID = -7148361047167117086L;

	@Override
	public User save(User entity) throws Exception {
		return super.save(entity);
	}

}
