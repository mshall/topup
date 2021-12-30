package com.topup.charging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestVO {

	@NotNull
	private double amount;
	@NotNull
	private String currency;
	
	@NotNull
	@JsonProperty("charge_id")
	private String chargeId;
	
	@NotNull
	@JsonProperty("customer")
	private TransactionCustomerVO customer;
	
	@JsonProperty("fees")
	private FeesVO fees;
}
