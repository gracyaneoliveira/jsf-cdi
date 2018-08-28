package com.project.controller;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.Logger;

import com.project.entity.Post;
import com.project.service.PostService;

@Named
@ViewScoped
public class PostBean implements Serializable{

	private static final long serialVersionUID = 3703541272682037660L;
	
	@Inject
	private Logger logger;
	
	@Inject
	private PostService postService;
	
	private Post post;

	@PostConstruct
	private void instance() {
		newEntity();
	}
	
	private void newEntity() {
		this.post = new Post();
	}

	public void save() {
		post.setPost("Injeção de dependência com CDI!");
		post.setDatePost(new Date());
		try {
			Post ps = postService.save(post);
			logger.info("Save a post:{} from id {}", ps.getPost(), ps.getId());
			newEntity();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* getters and setters */
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
