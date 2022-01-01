package com.topup.charging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseVO {

	String id;
	String created;
	String status;
	double amount;
	String currency;
	@JsonProperty("charge_id")
	String chargeId;
	TransactionCustomerVO customer;
	FeesVO fees;
	BalanceVO balance;

}
