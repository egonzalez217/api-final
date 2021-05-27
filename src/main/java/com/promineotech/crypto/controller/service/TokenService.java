package com.promineotech.crypto.controller.service;

import java.util.List;

import com.promineotech.crypto.token.entity.Token;

public interface TokenService {

        /**
         * @return List of crypto users
         */
    
        List<Token> getTokens();
        
        /**
         * 
         * @param user - data for new user
         * @return - New crypto user 
         */
        Token createToken(Token token);
}
