package com.project.repository;

import java.util.List;

import com.project.dao.GenericDao;
import com.project.entity.Post;

public interface PostRepository extends GenericDao<Post,Long>{
	
	List<Post> findByName(Post post);

}
