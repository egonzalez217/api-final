package com.promineotech.crypto.controller.dao;

import java.util.List;

import com.promineotech.crypto.wallet.entity.Wallet;

public interface WalletDao {

        /**
         * @return list of crypto wallets
         */
        
        List<Wallet> getWallets();
        
        /**
         * 
         * @param wallet = new wallet doa to be created
         * @return newly created crypto wallet
         */
        Wallet createWallet(Wallet wallet);
        
        /**
         * 
         * @param walletId = key for which to delete a wallet from the wallet table
         * @return nothing, delete a wallet from the database
         */
        void deleteWallet(int walletId);
}        