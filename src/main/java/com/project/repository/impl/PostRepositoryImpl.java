package com.project.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import com.project.entity.Post;
import com.project.repository.GenericDaoRepositoryImpl;
import com.project.repository.PostRepository;

public class PostRepositoryImpl extends GenericDaoRepositoryImpl<Post,Long> implements PostRepository, Serializable{

	private static final long serialVersionUID = -5050051322840831503L;

	@Override
	public Post save(Post entity) throws Exception {
		return super.save(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Post> findByName(Post post) {
		Query query = getEntityManager().createQuery("select p from Post p where p.post = :param");
		query.setParameter("param", post.getPost());
		return query.getResultList();
	}
}
