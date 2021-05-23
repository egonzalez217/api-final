package com.promineotech.crypto.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Exchange {
	
	@JsonProperty("exchange_id")
	private int exchangeId;
	
	@JsonProperty("exchange_name")
	private String exchangeName;

}
