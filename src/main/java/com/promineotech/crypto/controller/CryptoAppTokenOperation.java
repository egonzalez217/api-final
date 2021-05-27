package com.promineotech.crypto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;

import com.promineotech.crypto.token.entity.Token;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


// @formatter:off
@RequestMapping("/tokens")
@OpenAPIDefinition(
		info = @Info(title = "Token API"),
		servers = {@Server(url = "http://localhost:8080", description = "Local Server")})
// @formatter:on
public interface CryptoAppTokenOperation {

	// @formatter:off
	@Operation(
			summary = "Returns a list of tokens",
			description = "Returns a list of tokens",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "A list of tokens is returned",
							content = @Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = Token.class))), 
					@ApiResponse(
							responseCode = "500",
							description = "Internal server error occurred",
							content = @Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE))
			})
	// @formatter:on
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Token> getTokens();
	
	// @formatter:off
		@Operation(
				summary = "Creates crypto token",
				description = "Creates a new crypto token",
				responses = {
						@ApiResponse(
								responseCode = "201",
								description = "A crypto token is created successfully",
								content = @Content(
										mediaType = MediaType.APPLICATION_JSON_VALUE,
										schema = @Schema(implementation = Token.class))), 
						@ApiResponse(
								responseCode = "400",
								description = "Invalid input for token data",
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
	Token createToken(@RequestBody Token token);
		
}
