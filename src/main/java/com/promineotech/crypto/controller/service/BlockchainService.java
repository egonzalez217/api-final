package com.promineotech.crypto.controller.service;

import java.util.List;

import com.promineotech.crypto.blockchain.entity.Blockchain;

public interface BlockchainService {

        /**
         * @return List of crypto users
         */
    
        List<Blockchain> getBlockchains();
        
        /**
         * 
         * @param user - data for new user
         * @return - New crypto user 
         */
        Blockchain createBlockchain(Blockchain blockchain);
        
        
        /**
         * 
         * @param int - userId for a user entity
         * @return - nothing, record is deleted
         */
        void deleteBlockchain(int blockchainId);
}
