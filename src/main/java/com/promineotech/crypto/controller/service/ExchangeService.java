package com.promineotech.crypto.controller.service;

import java.util.List;

import com.promineotech.crypto.entity.Exchange;

public interface ExchangeService {

        /**
         * @return List of crypto users
         */
    
        List<Exchange> getExchanges();
        
        /**
         * 
         * @param user - data for new user
         * @return - New crypto user 
         */
        Exchange createExchange(Exchange exchange);
        
        
        /**
         * 
         * @param int - userId for a user entity
         * @return - nothing, record is deleted
         */
        void deleteExchange(int exchangeId);
}
