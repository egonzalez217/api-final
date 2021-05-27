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

import com.promineotech.crypto.token.entity.Token;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultTokenDao implements TokenDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    @Autowired
    private JdbcTemplate rawJdbcTemplate;
    
    @Override
    public List<Token> getTokens() {
        log.debug("Inside DAO layer getTokens()");
        
        final String sql = "SELECT * FROM crypto_token";
        
        return jdbcTemplate.query(sql, new RowMapper<Token>() {

            @Override
            public Token mapRow(ResultSet rs, int rowNum) throws SQLException {
                // @formatter:off
                return Token.builder()
                        .tokenId(rs.getInt("token_id"))
                        .cryptoId(rs.getInt("crypto_id"))
                        .cryptoName(rs.getString("crypto_name"))
                        .bid(rs.getInt("bid"))
                        .ask(rs.getInt("ask"))
                        .build();
                // @formatter:on
            }});
    }
    
    @Override
    public Token createToken(Token token) {
        log.debug("Inside DAO layer createToken()");
        
        // @formatter:off
        
        final String sql = "INSERT INTO crypto_token (token_id, crypto_id, crypto_name, bid, ask) VALUES (:token_id, :crypto_id, :crypto_name, :bid, :ask)";
        
        SqlParameterSource sqlParams = 
                new MapSqlParameterSource("token_id", token.getTokenId())
                        .addValue("crypto_id", token.getCryptoId())
                        .addValue("crypto_name", token.getCryptoName())
                        .addValue("bid", token.getBid())
                        .addValue("ask", token.getAsk());
        //@formatter:on
        
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(sql, sqlParams, keyHolder);
        
        int tokenId = keyHolder.getKey().intValue();
        
        //@formatter:off
        
        return Token.builder()
                .tokenId(tokenId)
                .cryptoId(token.getCryptoId())
                .cryptoName(token.getCryptoName())
                .bid(token.getBid())
                .ask(token.getAsk())
                .build();
        //@formatter:on
    }

}
