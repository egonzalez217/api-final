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

import com.promineotech.crypto.user.entity.User;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultUserDao implements UserDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplate rawJdbcTemplate;
	
	@Override
	public List<User> getUsers() {
		log.debug("Inside DAO layer getUsers()");
		
		final String sql = "SELECT * FROM crypto_user";
		
		return jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return User.builder()
						.userId(rs.getInt("user_id"))
						.userName(rs.getString("user_name"))
						.isMiner(rs.getString("is_miner"))
						.build();
				// @formatter:on
			}});
	}
	
	@Override
	public User createUser(User user) {
		log.debug("Inside DAO layer createUser()");
		
		// @formatter:off
		
		final String sql = "INSERT INTO crypto_user (user_name, is_miner) VALUES (:user_name, :is_miner)";
		
		SqlParameterSource sqlParams = 
				new MapSqlParameterSource("user_name", user.getUserName())
						.addValue("is_miner", user.getIsMiner());
		//@formatter:on
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(sql, sqlParams, keyHolder);
		
		int userId = keyHolder.getKey().intValue();
		
		//@formatter:off
		
		return User.builder()
				.userId(userId)
				.userName(user.getUserName())
				.isMiner(user.getIsMiner())
				.build();
		//@formatter:on
	}

	@Override
	public void deleteUser(int userId) {
		log.debug("Inside DAO layer deleteUser()");
		
		// @formatter:off
		
		
		final String sql = "DELETE FROM crypto_user WHERE user_id = ?";
		
		rawJdbcTemplate.update(sql, userId);
		//@formatter:off
		
		return;
		//@formatter:on
	}
	
	@Override
	public void setUserIsMiner(int userId) {
		log.debug("Inside DAO layer setUserIsMiner()");
		
		//@formatter:off
		final String sql = "UPDATE crypto_user SET is_miner = \"Miner\" WHERE user_id = ?";
		//@formatter:on
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		rawJdbcTemplate.update(sql, userId);
		
		//@formatter:off

		return;
				
	}
}
