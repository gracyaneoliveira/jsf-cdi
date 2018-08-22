package com.project.service;

import java.util.List;

import javax.inject.Inject;

import com.project.dao.GenericDao;

public abstract class AbstractGenericServiceImpl<T, K, R> implements GenericService<T, K>{

	@Inject
	private R repository;
	
    @SuppressWarnings("unchecked")
	public GenericDao<T,K> getGenericDao(){
    	return (GenericDao<T, K>) repository;
    };	
	
	@Override
	public T save(T entity) throws Exception {
		return getGenericDao().save(entity);
	}	
	
	@Override
	public T update(T entity) {
		return getGenericDao().update(entity);
	}
	
	@Override
	public List<T> list() {
		return getGenericDao().list();
	}
	
	@Override
	public void delete(T entity) {
		getGenericDao().delete(entity);
	}
	
	@Override
	public T getById(K id) {
		return getGenericDao().getById(id);
	}
}
