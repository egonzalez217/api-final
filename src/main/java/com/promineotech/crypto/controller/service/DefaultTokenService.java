package com.promineotech.crypto.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.crypto.token.entity.Token;
import com.promineotech.crypto.controller.dao.TokenDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultTokenService implements TokenService {

    @Autowired
    private TokenDao tokenDao;
    @Override
    public List<Token> getTokens() {
        log.debug("Inside service layer getTokens()");
        List<Token> tokens = tokenDao.getTokens();
        
        return tokens;
    }
    @Override
    public Token createToken(Token token) {
        log.debug("Inside service layer createToken()");
        
        return tokenDao.createToken(token);
    }

}
