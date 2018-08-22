package com.project.service.impl;

import java.io.Serializable;
import java.util.List;

import com.project.config.transactional.Transactional;
import com.project.entity.Post;
import com.project.repository.PostRepository;
import com.project.service.AbstractGenericServiceImpl;
import com.project.service.PostService;

public class PostServiceImpl extends AbstractGenericServiceImpl<Post, Long, PostRepository> implements PostService, Serializable{

	private static final long serialVersionUID = -212402270531005807L;
	
//	@Inject
//	private PostRepository postRepository;

	@Override
	@Transactional
	public Post save(Post entity) throws Exception {
		validateEntity(entity);
		return getGenericDao().save(entity);
	}
	
	private void validateEntity(Post entity) throws Exception {
		if(entity.getPost() == null || entity.getPost().isEmpty()) {
			throw new Exception("Entity invalid!");
		}
	}

	@Override
	public Post update(Post entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Post entity) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	protected GenericDao<Post, Long> getGenericDao() {
//		return postRepository;
//	}

}
