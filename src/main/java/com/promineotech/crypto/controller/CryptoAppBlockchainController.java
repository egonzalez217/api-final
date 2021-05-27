package com.promineotech.crypto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.crypto.controller.service.BlockchainService;
import com.promineotech.crypto.blockchain.entity.Blockchain;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CryptoAppBlockchainController implements CryptoAppBlockchainOperation{

    @Autowired
    private BlockchainService blockchainService;
    
    @Override
    public List<Blockchain> getBlockchains() {
        log.debug("Inside controller layer getBlockchains method");
        
        return blockchainService.getBlockchains();
    }

    @Override
    public Blockchain createBlockchain(Blockchain blockchain) {
        log.debug("Inside controller layer createBlockchain method");
        
        return blockchainService.createBlockchain(blockchain);
    }
    
    @Override
    public void deleteBlockchain(int blockchainId) {
        log.debug("Inside controller later deleteBlockchain method");
        
        blockchainService.deleteBlockchain(blockchainId);
        return;
    }
}
