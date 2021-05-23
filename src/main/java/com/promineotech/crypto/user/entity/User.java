package com.promineotech.crypto.user.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class User {

		@JsonProperty("user_id")
		private int userId;
		
		@JsonProperty("user_name")
		private String userName;
		
		@JsonProperty("is_miner")
		private String isMiner;
}
