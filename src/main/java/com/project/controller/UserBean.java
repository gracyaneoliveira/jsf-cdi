package com.project.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.Logger;

import com.project.entity.User;
import com.project.service.UserService;

@Named
@ViewScoped
public class UserBean implements Serializable{

	private static final long serialVersionUID = -4069657624157222269L;

	@Inject
	private Logger logger;
	
	@Inject
	private UserService userService;

	private User user;
	
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
			User u = userService.save(user);
			logger.info("Save a user:{} from id {}", u.getName(), u.getId());
			newEntity();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* getters and setters */
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
