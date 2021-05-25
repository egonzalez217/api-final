package com.promineotech.crypto.controller.service;

import java.util.List;

import com.promineotech.crypto.user.entity.User;

public interface UserService {

		/**
		 * @return List of crypto users
		 */
	
		List<User> getUsers();
		
		/**
		 * 
		 * @param user - data for new user
		 * @return - New crypto user 
		 */
		User createUser(User user);
}
