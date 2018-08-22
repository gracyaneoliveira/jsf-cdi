package com.project.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.project.entity.User;
import com.project.service.UserService;

@Named
@ViewScoped
public class UserBean implements Serializable{

	private static final long serialVersionUID = -4069657624157222269L;

private User user;
	
	@Inject
	private UserService userService;
	
	@PostConstruct
	private void instance() {
		newEntity();
	}
	
	private void newEntity() {
		this.user = new User();
	}

	public void save() {
		user.setName("name user");
		try {
			userService.save(user);
			newEntity();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* getters and settters */
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
