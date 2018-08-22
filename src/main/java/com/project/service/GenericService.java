package com.project.service;

import java.util.List;

public interface GenericService <T, K>{

	T save(final T entity) throws Exception;

	T update(final T entity);

	List<T> list();

	T getById(final K id);

	void delete(final T entity);
}
