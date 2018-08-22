package com.project.service.impl;

import java.io.Serializable;

import com.project.config.transactional.Transactional;
import com.project.entity.User;
import com.project.repository.UserRepository;
import com.project.service.AbstractGenericServiceImpl;
import com.project.service.UserService;

public class UserServiceImpl extends AbstractGenericServiceImpl<User, Long, UserRepository> implements UserService, Serializable {

	private static final long serialVersionUID = 6251770727785879174L;

	@Override
	@Transactional
	public User save(User entity) throws Exception {
		validateEntity(entity);
		return getGenericDao().save(entity);
	}
	
	private void validateEntity(User entity) throws Exception {
		if(entity.getName() == null || entity.getName().isEmpty()) {
			throw new Exception("Entity invalid!");
		}
	}
}
