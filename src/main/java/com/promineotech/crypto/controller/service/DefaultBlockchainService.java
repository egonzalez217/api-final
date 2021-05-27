package com.promineotech.crypto.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.crypto.blockchain.entity.Blockchain;
import com.promineotech.crypto.controller.dao.BlockchainDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultBlockchainService implements BlockchainService {

    @Autowired
    private BlockchainDao blockchainDao;
    @Override
    public List<Blockchain> getBlockchains() {
        log.debug("Inside service layer getBlockchains()");
        List<Blockchain> blockchains = blockchainDao.getBlockchains();
        
        return blockchains;
    }
    @Override
    public Blockchain createBlockchain(Blockchain blockchain) {
        log.debug("Inside service layer createBlockchain()");
        
        return blockchainDao.createBlockchain(blockchain);
    }
    
    @Override
    public void deleteBlockchain(int blockchainId) {
        log.debug("Inside service layer deleteBlockchain");
        
        blockchainDao.deleteBlockchain(blockchainId);
        return;
    }

}
