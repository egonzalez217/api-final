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

import com.promineotech.crypto.blockchain.entity.Blockchain;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


// @formatter:off
@RequestMapping("/blockchains")
@OpenAPIDefinition(
        info = @Info(title = "Blockchain API"),
        servers = {@Server(url = "http://localhost:8080", description = "Local Server")})
// @formatter:on
public interface CryptoAppBlockchainOperation {

    // @formatter:off
    @Operation(
            summary = "Returns a list of blockchains",
            description = "Returns a list of blockchains",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "A list of blockchains is returned",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Blockchain.class))), 
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error occurred",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    // @formatter:on
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<Blockchain> getBlockchains();
    
    // @formatter:off
        @Operation(
                summary = "Creates crypto blockchain",
                description = "Creates a new crypto blockchain",
                responses = {
                        @ApiResponse(
                                responseCode = "201",
                                description = "A crypto blockchain is created successfully",
                                content = @Content(
                                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                                        schema = @Schema(implementation = Blockchain.class))), 
                        @ApiResponse(
                                responseCode = "400",
                                description = "Invalid input for blockchain data",
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
    Blockchain createBlockchain(@RequestBody Blockchain blockchain);
        
    // @formatter:off
            @Operation(
                    summary = "Deletes crypto blockchain",
                    description = "Deletes a crypto blockchain from the crypto_blockchain table",
                    responses = {
                            @ApiResponse(
                                    responseCode = "200",
                                    description = "A crypto blockchain is deleted successfully",
                                    content = @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Blockchain.class))), 
                            @ApiResponse(
                                    responseCode = "400",
                                    description = "Invalid input for blockchainId",
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
    void deleteBlockchain(@RequestBody int blockchainId);
        
}
