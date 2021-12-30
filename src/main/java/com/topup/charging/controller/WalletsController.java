package com.topup.charging.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.topup.charging.dto.ResponseVO;
import com.topup.charging.dto.TransactionResponseVO;
import com.topup.charging.entity.Wallets;
import com.topup.charging.service.WalletsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/wallets")
@Slf4j
public class WalletsController {

	@Autowired
	private WalletsService WalletsService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseVO<List<Wallets>> findAllWallets() {
		List<Wallets> wallets = WalletsService.findAllWallets();
		ResponseVO response = new ResponseVO<List<Wallets>>();
		response.setResults(wallets);
		return response;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
	public ResponseVO<Wallets> addNewWallet(@Valid @RequestBody Wallets wallet) {
		Wallets walletresponse = WalletsService.addNewWallet(wallet);
		ResponseVO response = new ResponseVO<TransactionResponseVO>();
		response.setResults(walletresponse);
		return response;
	}

}
