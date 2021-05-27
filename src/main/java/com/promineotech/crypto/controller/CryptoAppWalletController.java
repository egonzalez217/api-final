package com.promineotech.crypto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.crypto.controller.service.WalletService;
import com.promineotech.crypto.wallet.entity.Wallet;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CryptoAppWalletController implements CryptoAppWalletOperation{

    @Autowired
    private WalletService walletService;
    
    @Override
    public List<Wallet> getWallets() {
        log.debug("Inside wallet layer getUsers method");
        
        return walletService.getWallets();
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        log.debug("Inside controller layer createUser method");
        
        return walletService.createWallet(wallet);
    }
    
    @Override
    public void deleteWallet(int walletId) {
        log.debug("Inside controller later deleteWallet method");
        
        walletService.deleteWallet(walletId);
        return;
    }
}
