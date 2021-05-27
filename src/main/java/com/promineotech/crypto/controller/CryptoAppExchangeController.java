package com.promineotech.crypto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.crypto.controller.service.ExchangeService;
import com.promineotech.crypto.entity.Exchange;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CryptoAppExchangeController implements CryptoAppExchangeOperation{

    @Autowired
    private ExchangeService exchangeService;
    
    @Override
    public List<Exchange> getExchanges() {
        log.debug("Inside controller layer getExchanges method");
        
        return exchangeService.getExchanges();
    }

    @Override
    public Exchange createExchange(Exchange exchange) {
        log.debug("Inside controller layer createExchange method");
        
        return exchangeService.createExchange(exchange);
    }
    
    @Override
    public void deleteExchange(int exchangeId) {
        log.debug("Inside controller later deleteExchange method");
        
        exchangeService.deleteExchange(exchangeId);
        return;
    }
}
