package com.topup.charging.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	private String customerId;
	private double feesAmount;
	private int feesCurrencyId;
	private double finalAmount;
	private String chargeId;
	private String status;
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

}
