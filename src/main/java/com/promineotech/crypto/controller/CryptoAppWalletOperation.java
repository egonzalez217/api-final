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

import com.promineotech.crypto.wallet.entity.Wallet;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


// @formatter:off
@RequestMapping("/wallet")
@OpenAPIDefinition(
        info = @Info(title = "User API"),
        servers = {@Server(url = "http://localhost:8080", description = "Local Server")})
// @formatter:on
public interface CryptoAppWalletOperation {

    // @formatter:off
    @Operation(
            summary = "Returns a list of wallet",
            description = "Returns a list of wallet",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "A list of wallet is returned",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Wallet.class))), 
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error occurred",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    // @formatter:on
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<Wallet> getWallets();
    
    // @formatter:off
        @Operation(
                summary = "Creates crypto wallet",
                description = "Creates a new crypto wallet (Wallet ID must reference an existing User ID. Please create a new user first if you wish to associate a new wallet with a new user).",
                responses = {
                        @ApiResponse(
                                responseCode = "201",
                                description = "A crypto wallet is created successfully",
                                content = @Content(
                                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                                        schema = @Schema(implementation = Wallet.class))), 
                        @ApiResponse(
                                responseCode = "400",
                                description = "Invalid input for wallet data",
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
    Wallet createWallet(@RequestBody Wallet wallet);
        
    // @formatter:off
            @Operation(
                    summary = "Deletes crypto wallet",
                    description = "Deletes a crypto wallet from the wallet table",
                    responses = {
                            @ApiResponse(
                                    responseCode = "200",
                                    description = "A crypto wallet is deleted successfully",
                                    content = @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Wallet.class))), 
                            @ApiResponse(
                                    responseCode = "400",
                                    description = "Invalid input for walletId",
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
    void deleteWallet(@RequestBody int walletId);
        
}
