package com.promineotech.crypto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.crypto.controller.service.TokenService;
import com.promineotech.crypto.token.entity.Token;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CryptoAppTokenController implements CryptoAppTokenOperation{

    @Autowired
    private TokenService tokenService;
    
    @Override
    public List<Token> getTokens() {
        log.debug("Inside controller layer getTokens method");
        
        return tokenService.getTokens();
    }

    @Override
    public Token createToken(Token token) {
        log.debug("Inside controller layer createToken method");
        
        return tokenService.createToken(token);
    }
    
}
