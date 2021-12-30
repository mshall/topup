package com.topup.charging.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.topup.charging.dto.ResponseVO;
import com.topup.charging.entity.Customers;
import com.topup.charging.service.CustomersService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomersController {

	@Autowired
	private CustomersService customersService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseVO<List<Customers>> findAllCustomers() {
		List<Customers> customers =  customersService.findAllCustomers();
		@SuppressWarnings("rawtypes")
		ResponseVO response = new ResponseVO<List<Customers>>();
		response.setResults(customers);
		return response;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
	public ResponseVO<Customers> addNewCustomer(@Valid @RequestBody Customers customer) {
		Customers customerResult = customersService.addNewCustomer(customer);
		ResponseVO response = new ResponseVO<Customers>();
		response.setResults(customerResult);
		return response;
	}

}
