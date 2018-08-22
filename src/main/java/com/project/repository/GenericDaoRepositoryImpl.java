package com.project.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.project.dao.GenericDao;

public abstract class GenericDaoRepositoryImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

	private Class<T> clazz;

	@Inject
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@SuppressWarnings("unchecked")
	public GenericDaoRepositoryImpl() {
		setClazz((Class<T>) ((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
	}

	@Override
	public T save(T entity) throws Exception{
		getEntityManager().persist(entity);
		getEntityManager().flush();
		return entity;
	}

	@Override
	public T update(T entity) {
		return this.getEntityManager().merge(entity);
	}

	@Override
	public List<T> list() {
		return getEntityManager().createQuery("from " + getClazz().getName(), getClazz()).getResultList();
	}

	@Override
	public T getById(ID id) {
		return getEntityManager().find(clazz, id);
	}

	@Override
	public void delete(T entity) {
		getEntityManager().remove( entity );
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

}
