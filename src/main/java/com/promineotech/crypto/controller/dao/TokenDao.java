package com.promineotech.crypto.controller.dao;

import java.util.List;

import com.promineotech.crypto.token.entity.Token;

public interface TokenDao {

        /**
         * @return list of crypto users
         */
        
        List<Token> getTokens();
        
        /**
         * 
         * @param user = new user doa to be created
         * @return newly created crypto user
         */
        Token createToken(Token token);
        
}
