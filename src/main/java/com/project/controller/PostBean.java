package com.project.controller;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.project.entity.Post;
import com.project.service.PostService;

@Named
@ViewScoped
public class PostBean implements Serializable{

	private static final long serialVersionUID = 3703541272682037660L;
	
	private Post post;
	
	@Inject
	private PostService postService;
	
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
			postService.save(post);
			newEntity();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* getters and settters */
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
