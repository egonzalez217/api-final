package com.promineotech.crypto.wallet.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Wallet {

	@JsonProperty("wallet_id")
	private int walletId;
	
	@JsonProperty("crypto_id")
	private int cryptoId;
	
	@JsonProperty("price_bought_at")
	private int priceBoughtAt;
}
