package com.promineotech.crypto.token.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Token {
    
    @JsonProperty("token_id")
    private int tokenId;
    
    @JsonProperty("crypto_id")
    private int cryptoId;
    
    @JsonProperty("crypto_name")
    private String cryptoName;
    
    private int bid;
    
    private int ask;

}