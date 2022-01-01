package com.topup.charging.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionCustomerVO {

	@NotNull(message = "id may not be null")
	@JsonProperty("id")
	String id;
	@NotNull(message = "wallet_id may not be null")
	@JsonProperty("wallet_id")
	String walletId;
}
