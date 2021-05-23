package com.promineotech.crypto.token.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CryptoToken {
	
	@JsonProperty("token_id")
	private int tokenId;
	
	@JsonProperty("crypto_id")
	private int cryptoId;
	
	@JsonProperty("crypto_name")
	private String cryptoName;
	
	private int bid;
	
	private int ask;

}
