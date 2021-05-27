package com.promineotech.crypto.controller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.crypto.entity.Exchange;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultExchangeDao implements ExchangeDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    @Autowired
    private JdbcTemplate rawJdbcTemplate;
    
    @Override
    public List<Exchange> getExchanges() {
        log.debug("Inside DAO layer getExchanges()");
        
        final String sql = "SELECT * FROM crypto_exchange";
        
        return jdbcTemplate.query(sql, new RowMapper<Exchange>() {

            @Override
            public Exchange mapRow(ResultSet rs, int rowNum) throws SQLException {
                // @formatter:off
                return Exchange.builder()
                        .exchangeId(rs.getInt("exchange_id"))
                        .exchangeName(rs.getString("exchange_name"))
                        .build();
                // @formatter:on
            }});
    }
    
    @Override
    public Exchange createExchange(Exchange exchange) {
        log.debug("Inside DAO layer createExchange()");
        
        // @formatter:off
        
        final String sql = "INSERT INTO crypto_exchange (exchange_name) VALUES (:exchange_name)";
        
        SqlParameterSource sqlParams = 
                new MapSqlParameterSource("exchange_name", exchange.getExchangeName());
        //@formatter:on
        
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(sql, sqlParams, keyHolder);
        
        int exchangeId = keyHolder.getKey().intValue();
        
        //@formatter:off
        
        return Exchange.builder()
                .exchangeId(exchangeId)
                .exchangeName(exchange.getExchangeName())
                .build();
        //@formatter:on
    }

    @Override
    public void deleteExchange(int exchangeId) {
        log.debug("Inside DAO layer deleteExchange()");
        
        // @formatter:off
        
        
        final String sql = "DELETE FROM crypto_exchange WHERE exchange_id = ?";
        
        //SqlParameterSource sqlParams = 
            //  new MapSqlParameterSource("token_id", tokenId);
        //@formatter:on
        
        //KeyHolder keyHolder = new GeneratedKeyHolder();
        
        //jdbcTemplate.update(sql, sqlParams, keyHolder);
        rawJdbcTemplate.update(sql, exchangeId);
        //@formatter:off
        
        return;
        //@formatter:on
    }
}
