package com.promineotech.crypto.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.crypto.entity.Exchange;
import com.promineotech.crypto.controller.dao.ExchangeDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultExchangeService implements ExchangeService {

    @Autowired
    private ExchangeDao exchangeDao;
    @Override
    public List<Exchange> getExchanges() {
        log.debug("Inside service layer getExchanges()");
        List<Exchange> exchanges = exchangeDao.getExchanges();
        
        return exchanges;
    }
    @Override
    public Exchange createExchange(Exchange exchange) {
        log.debug("Inside service layer createExchange()");
        
        return exchangeDao.createExchange(exchange);
    }
    
    @Override
    public void deleteExchange(int exchangeId) {
        log.debug("Inside service layer deleteExchange");
        
        exchangeDao.deleteExchange(exchangeId);
        return;
    }

}
