package com.promineotech.crypto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;

import com.promineotech.crypto.user.entity.User;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


// @formatter:off
@RequestMapping("/users")
@OpenAPIDefinition(
		info = @Info(title = "User API"),
		servers = {@Server(url = "http://localhost:8080", description = "Local Server")})
// @formatter:on
public interface CryptoAppUserOperation {

	// @formatter:off
	@Operation(
			summary = "Returns a list of users",
			description = "Returns a list of users",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "A list of users is returned",
							content = @Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = User.class))), 
					@ApiResponse(
							responseCode = "500",
							description = "Internal server error occurred",
							content = @Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE))
			})
	// @formatter:on
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<User> getUsers();
	
	// @formatter:off
		@Operation(
				summary = "Creates crypto user",
				description = "Creates a new crypto user",
				responses = {
						@ApiResponse(
								responseCode = "201",
								description = "A crypto user is created successfully",
								content = @Content(
										mediaType = MediaType.APPLICATION_JSON_VALUE,
										schema = @Schema(implementation = User.class))), 
						@ApiResponse(
								responseCode = "400",
								description = "Invalid input for user data",
								content = @Content(
										mediaType = MediaType.APPLICATION_JSON_VALUE)),
						@ApiResponse(
								responseCode = "500",
								description = "Internal server error occurred",
								content = @Content(
										mediaType = MediaType.APPLICATION_JSON_VALUE))
				})
		// @formatter:on
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	User createUser(@RequestBody User user);
		
	// @formatter:off
			@Operation(
					summary = "Deletes crypto user",
					description = "Deletes a crypto user from the crypto_user table",
					responses = {
							@ApiResponse(
									responseCode = "200",
									description = "A crypto user is deleted successfully",
									content = @Content(
											mediaType = MediaType.APPLICATION_JSON_VALUE,
											schema = @Schema(implementation = User.class))), 
							@ApiResponse(
									responseCode = "400",
									description = "Invalid input for userId",
									content = @Content(
											mediaType = MediaType.APPLICATION_JSON_VALUE)),
							@ApiResponse(
									responseCode = "500",
									description = "Internal server error occurred",
									content = @Content(
											mediaType = MediaType.APPLICATION_JSON_VALUE))
						})
			// @formatter:on
			
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	void deleteUser(@RequestBody int userId);
		
}
