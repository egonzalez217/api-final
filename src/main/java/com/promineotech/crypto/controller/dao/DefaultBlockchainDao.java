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

import com.promineotech.crypto.blockchain.entity.Blockchain;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultBlockchainDao implements BlockchainDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    @Autowired
    private JdbcTemplate rawJdbcTemplate;
    
    @Override
    public List<Blockchain> getBlockchains() {
        log.debug("Inside DAO layer getBlockchains()");
        
        final String sql = "SELECT * FROM blockchain";
        
        return jdbcTemplate.query(sql, new RowMapper<Blockchain>() {

            @Override
            public Blockchain mapRow(ResultSet rs, int rowNum) throws SQLException {
                // @formatter:off
                return Blockchain.builder()
                        .blockchainId(rs.getInt("blockchain_id"))
                        .blockchainName(rs.getString("blockchain_name"))
                        .build();
                // @formatter:on
            }});
    }
    
    @Override
    public Blockchain createBlockchain(Blockchain blockchain) {
        log.debug("Inside DAO layer createBlockchain()");
        
        // @formatter:off
        
        final String sql = "INSERT INTO blockchain (blockchain_name) VALUES (:blockchain_name)";
        
        SqlParameterSource sqlParams = 
                new MapSqlParameterSource("blockchain_name", blockchain.getBlockchainName());
        //@formatter:on
        
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(sql, sqlParams, keyHolder);
        
        int blockchainId = keyHolder.getKey().intValue();
        
        //@formatter:off
        
        return Blockchain.builder()
                .blockchainId(blockchainId)
                .blockchainName(blockchain.getBlockchainName())
                .build();
        //@formatter:on
    }

    @Override
    public void deleteBlockchain(int blockchainId) {
        log.debug("Inside DAO layer deleteBlockchain()");
        
        // @formatter:off
        
        
        final String sql = "DELETE FROM blockchain WHERE blockchain_id = ?";
        
        //SqlParameterSource sqlParams = 
            //  new MapSqlParameterSource("user_id", userId);
        //@formatter:on
        
        //KeyHolder keyHolder = new GeneratedKeyHolder();
        
        //jdbcTemplate.update(sql, sqlParams, keyHolder);
        rawJdbcTemplate.update(sql, blockchainId);
        //@formatter:off
        
        return;
        //@formatter:on
    }
}
