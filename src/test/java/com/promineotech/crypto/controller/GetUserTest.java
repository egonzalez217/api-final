package com.promineotech.crypto.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.promineotech.crypto.controller.support.GetUserTestSupport;
import com.promineotech.crypto.user.entity.User;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class GetUserTest extends GetUserTestSupport {

	@Test
	void test() {
		System.out.println(getBaseUri());
	}
	
	@Test
	void getUsers_users_returnsListOfUsers() {
		
		ResponseEntity<User> response =
				getRestTemplate().getForEntity(getBaseUri(), User.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
