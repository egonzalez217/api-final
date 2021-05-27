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

import com.promineotech.crypto.wallet.entity.Wallet;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultWalletDao implements WalletDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    @Autowired
    private JdbcTemplate rawJdbcTemplate;
    
    @Override
    public List<Wallet> getWallets() {
        log.debug("Inside DAO layer getWallets()");
        
        final String sql = "SELECT * FROM wallet";
        
        return jdbcTemplate.query(sql, new RowMapper<Wallet>() {

            @Override
            public Wallet mapRow(ResultSet rs, int rowNum) throws SQLException {
                // @formatter:off
                return Wallet.builder()
                        .walletId(rs.getInt("wallet_id"))
                        .cryptoId(rs.getInt("crypto_id"))
                        .priceBoughtAt(rs.getInt("price_bought_at"))
                        .build();
                // @formatter:on
            }});
    }
    
    @Override
    public Wallet createWallet(Wallet wallet) {
        log.debug("Inside DAO layer createWallet()");
        
        // @formatter:off
        
        final String sql = "INSERT INTO wallet (wallet_id, crypto_id, price_bought_at) VALUES (:wallet_id, :crypto_id, :price_bought_at)";
        
        SqlParameterSource sqlParams = 
                new MapSqlParameterSource("wallet_id", wallet.getWalletId())
                        .addValue("crypto_id", wallet.getCryptoId())
                        .addValue("price_bought_at", wallet.getPriceBoughtAt());
        //@formatter:on
        
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(sql, sqlParams, keyHolder);
        
        int walletId = keyHolder.getKey().intValue();
        
        //@formatter:off
        
        return Wallet.builder()
            .walletId(wallet.getWalletId())
            .cryptoId(wallet.getCryptoId())
            .priceBoughtAt(wallet.getPriceBoughtAt())
            .build();
        //@formatter:on
    }

    @Override
    public void deleteWallet(int walletId) {
        log.debug("Inside DAO layer deleteWallet()");
        
        // @formatter:off
        
        
        final String sql = "DELETE FROM wallet WHERE wallet_id = ?";
        
        //SqlParameterSource sqlParams = 
            //  new MapSqlParameterSource("user_id", userId);
        //@formatter:on
        
        //KeyHolder keyHolder = new GeneratedKeyHolder();
        
        //jdbcTemplate.update(sql, sqlParams, keyHolder);
        rawJdbcTemplate.update(sql, walletId);
        //@formatter:off
        
        return;
        //@formatter:on
    }
}
