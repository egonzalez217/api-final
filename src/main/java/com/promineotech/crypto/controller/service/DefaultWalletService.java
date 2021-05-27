package com.promineotech.crypto.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.crypto.wallet.entity.Wallet;
import com.promineotech.crypto.controller.dao.WalletDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultWalletService implements WalletService {

    @Autowired
    private WalletDao walletDao;
    @Override
    public List<Wallet> getWallets() {
        log.debug("Inside service layer getWallets()");
        List<Wallet> wallets = walletDao.getWallets();
        
        return wallets;
    }
    @Override
    public Wallet createWallet(Wallet wallet) {
        log.debug("Inside service layer createWallet()");
        
        return walletDao.createWallet(wallet);
    }
    
    @Override
    public void deleteWallet(int walletId) {
        log.debug("Inside service layer deleteWallet");
        
        walletDao.deleteWallet(walletId);
        return;
    }

}

