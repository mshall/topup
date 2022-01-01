package com.topup.charging.dto;

import java.util.List;

import com.topup.charging.entity.Customers;
import com.topup.charging.entity.Wallets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerVO {

	private Customers customer;
	private List<Wallets> customerWallets;
}
