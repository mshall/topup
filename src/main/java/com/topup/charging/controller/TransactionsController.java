package com.topup.charging.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.topup.charging.dto.ResponseVO;
import com.topup.charging.dto.TransactionRequestVO;
import com.topup.charging.dto.TransactionResponseVO;
import com.topup.charging.entity.Transactions;
import com.topup.charging.entity.Wallets;
import com.topup.charging.service.TransactionsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/charge")
@Slf4j
public class TransactionsController {

	@Autowired
	private TransactionsService transactionsService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseVO<List<Wallets>> findAllWallets() {
		List<Transactions> transactions = transactionsService.findAllTransactions();
		ResponseVO response = new ResponseVO<List<Transactions>>();
		response.setResults(transactions);
		return response;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
	public ResponseVO<TransactionResponseVO> processTransaction(@Valid @RequestBody TransactionRequestVO request) {
		TransactionResponseVO transactionResponse = transactionsService.procesTransactrion(request);
		ResponseVO response = new ResponseVO<TransactionResponseVO>();
		response.setResults(transactionResponse);
		return response;
	}

}
