package com.topup.charging.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.topup.charging.dto.ResponseVO;
import com.topup.charging.entity.Currency;
import com.topup.charging.entity.Customers;
import com.topup.charging.service.CurrencyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/currency")
@Slf4j
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseVO<List<Currency>> findAllCurrencies() {
		List<Currency> currencyList = currencyService.findAllCurrencies();
		@SuppressWarnings("rawtypes")
		ResponseVO response = new ResponseVO<List<Currency>>();
		response.setResults(currencyList);
		return response;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
	public ResponseVO<Currency> addNewCurrency(@Valid @RequestBody Currency currency) {
		Currency currencyResult = currencyService.addNewCurrency(currency);
		ResponseVO response = new ResponseVO<Currency>();
		response.setResults(currencyResult);
		return response;
	}

}
