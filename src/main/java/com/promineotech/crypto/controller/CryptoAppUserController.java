package com.promineotech.crypto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.promineotech.crypto.user.entity.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CryptoAppUserController implements CryptoAppUserOperation{

	@Override
	public List<User> getUsers() {
		log.debug("Inside getUsers method");
		
		return null;
	}

}
