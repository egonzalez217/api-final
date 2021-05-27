package com.promineotech.crypto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.crypto.controller.service.UserService;
import com.promineotech.crypto.user.entity.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CryptoAppUserController implements CryptoAppUserOperation{

	@Autowired
	private UserService userService;
	
	@Override
	public List<User> getUsers() {
		log.debug("Inside controller layer getUsers method");
		
		return userService.getUsers();
	}

	@Override
	public User createUser(User user) {
		log.debug("Inside controller layer createUser method");
		
		return userService.createUser(user);
	}
	
	@Override
	public void deleteUser(int userId) {
		log.debug("Inside controller later deleteUser method");
		
		userService.deleteUser(userId);
		return;
	}
}
