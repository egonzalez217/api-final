package com.promineotech.crypto.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.crypto.user.entity.User;
import com.promineotech.crypto.controller.dao.UserDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultUserService implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public List<User> getUsers() {
		log.debug("Inside service layer getUsers()");
		List<User> users = userDao.getUsers();
		
		return users;
	}
	@Override
	public User createUser(User user) {
		log.debug("Inside service layer createUser()");
		
		return userDao.createUser(user);
	}
	
	@Override
	public void deleteUser(int userId) {
		log.debug("Inside service layer deleteUser");
		
		userDao.deleteUser(userId);
		return;
	}
	
	@Override
	public void setUserIsMiner(int userId) {
		log.debug("Inside service layer setUserIsMiner");
		
		userDao.setUserIsMiner(userId);
		return;
	}

}
