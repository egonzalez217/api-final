package com.promineotech.crypto.blockchain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Blockchain {
	
	@JsonProperty("blockchain_id")
	private int blockchainId;
	
	@JsonProperty("blockchain_name")
	private String blockchainName;

}
