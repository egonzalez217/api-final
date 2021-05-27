package com.promineotech.crypto.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Exchange {
	
	@JsonProperty("exchange_id")
	private int exchangeId;
	
	@JsonProperty("exchange_name")
	private String exchangeName;

}
