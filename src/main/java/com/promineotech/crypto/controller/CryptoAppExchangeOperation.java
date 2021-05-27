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

import com.promineotech.crypto.entity.Exchange;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


// @formatter:off
@RequestMapping("/exchanges")
@OpenAPIDefinition(
        info = @Info(title = "Exchange API"),
        servers = {@Server(url = "http://localhost:8080", description = "Local Server")})
// @formatter:on
public interface CryptoAppExchangeOperation {

    // @formatter:off
    @Operation(
            summary = "Returns a list of exchanges",
            description = "Returns a list of exchanges",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "A list of exchanges is returned",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Exchange.class))), 
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error occurred",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    // @formatter:on
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<Exchange> getExchanges();
    
    // @formatter:off
        @Operation(
                summary = "Creates crypto exchange",
                description = "Creates a new crypto exchange",
                responses = {
                        @ApiResponse(
                                responseCode = "201",
                                description = "A crypto exchange is created successfully",
                                content = @Content(
                                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                                        schema = @Schema(implementation = Exchange.class))), 
                        @ApiResponse(
                                responseCode = "400",
                                description = "Invalid input for exchange data",
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
    Exchange createExchange(@RequestBody Exchange exchange);
        
    // @formatter:off
            @Operation(
                    summary = "Deletes crypto exchange",
                    description = "Deletes a crypto exchange from the crypto_exchange table",
                    responses = {
                            @ApiResponse(
                                    responseCode = "200",
                                    description = "A crypto exchange is deleted successfully",
                                    content = @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Exchange.class))), 
                            @ApiResponse(
                                    responseCode = "400",
                                    description = "Invalid input for exchangeId",
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
    void deleteExchange(@RequestBody int exchangeId);
        
}
