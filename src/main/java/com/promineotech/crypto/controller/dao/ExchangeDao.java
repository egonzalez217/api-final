package com.promineotech.crypto.controller.dao;

import java.util.List;

import com.promineotech.crypto.entity.Exchange;

public interface ExchangeDao {

        /**
         * @return list of crypto users
         */
        
        List<Exchange> getExchanges();
        
        /**
         * 
         * @param user = new user doa to be created
         * @return newly created crypto user
         */
        Exchange createExchange(Exchange exchange);
        
        /**
         * 
         * @param userId = key for which to delete a user from the crypto_user table
         * @return nothing, delete a user from the database
         */
        void deleteExchange(int exchangeId);
        
}
