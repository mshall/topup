package com.topup.charging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionCustomerVO {

	@JsonProperty("id")
	String id;
	@JsonProperty("wallet_id")
	String walletId;
}
