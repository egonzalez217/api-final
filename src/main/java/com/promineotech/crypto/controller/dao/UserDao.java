package com.promineotech.crypto.controller.dao;

import java.util.List;

import com.promineotech.crypto.user.entity.User;

public interface UserDao {

		/**
		 * @return list of crypto users
		 */
		
		List<User> getUsers();
		
		/**
		 * 
		 * @param user = new user doa to be created
		 * @return newly created crypto user
		 */
		User createUser(User user);
		
		/**
		 * 
		 * @param userId = key for which to delete a user from the crypto_user table
		 * @return nothing, delete a user from the database
		 */
		void deleteUser(int userId);
		
}
