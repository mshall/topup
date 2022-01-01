package com.topup.charging.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestVO {

	@NotNull(message = "amount must have a value")
	@Min(value = 1,
			  message = "There must be at least {value}")
	private double amount;
	
	@NotNull(message = "currency must not be null")
	private String currency;
	
	@NotNull(message = "charge_id must not be null")
	@JsonProperty("charge_id")
	private String chargeId;
	
	@NotNull(message = "customer must not be null")
	@JsonProperty("customer")
	private TransactionCustomerVO customer;
	
	@JsonProperty("fees")
	private FeesVO fees;
}
