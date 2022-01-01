package com.topup.charging.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topup.charging.dto.CustomerVO;
import com.topup.charging.entity.Customers;
import com.topup.charging.entity.Wallets;
import com.topup.charging.repository.CustomersRepository;

@Service
public class CustomersService {

	@Autowired
	CustomersRepository customersRepository;
	
	@Autowired
	WalletsService walletsService;
	public List<Customers> findAllCustomers() {
		return customersRepository.findAll();
	}
	
	public CustomerVO findCustomerById(String customerId) {
		Optional<Customers> customer = customersRepository.findById(customerId);
		List<Wallets> customerWallets = walletsService.findWalletsByCustomerId(customerId);
		CustomerVO customerVO = new CustomerVO(customer.orElse(null), customerWallets);
		return customerVO;
	}
	
	public Customers addNewCustomer(Customers customer) {
		UUID uuid = UUID.randomUUID();
		customer.setId(uuid.toString());
		Customers result = customersRepository.save(customer);
		return result;
	}
	
	public Customers updateCustomer(Customers customer) {
		Customers result = customersRepository.save(customer);
		return result;
	}
	
	public void deleteCustomer(String customerId) {
		customersRepository.deleteById(customerId);		
	}
	
}
