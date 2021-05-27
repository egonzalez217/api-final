package com.promineotech.crypto.controller.service;

import java.util.List;

import com.promineotech.crypto.wallet.entity.Wallet;

public interface WalletService {

        /**
         * @return List of crypto wallets
         */
    
        List<Wallet> getWallets();
        
        /**
         * 
         * @param wallet - data for new wallet
         * @return - New crypto wallet 
         */
        Wallet createWallet(Wallet wallet);
        
        
        /**
         * 
         * @param int - walletId for a wallet entity
         * @return - nothing, record is deleted
         */
        void deleteWallet(int walletId);
}
