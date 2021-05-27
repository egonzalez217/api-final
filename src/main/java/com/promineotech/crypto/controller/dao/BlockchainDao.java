package com.promineotech.crypto.controller.dao;

import java.util.List;

import com.promineotech.crypto.blockchain.entity.Blockchain;

public interface BlockchainDao {

        /**
         * @return list of crypto users
         */
        
        List<Blockchain> getBlockchains();
        
        /**
         * 
         * @param user = new user doa to be created
         * @return newly created crypto user
         */
        Blockchain createBlockchain(Blockchain blockchain);
        
        /**
         * 
         * @param userId = key for which to delete a user from the crypto_user table
         * @return nothing, delete a user from the database
         */
        void deleteBlockchain(int blockchainId);
        
}
