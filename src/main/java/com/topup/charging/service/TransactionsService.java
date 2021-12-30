package com.topup.charging.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topup.charging.dto.BalanceVO;
import com.topup.charging.dto.FeesVO;
import com.topup.charging.dto.TransactionCustomerVO;
import com.topup.charging.dto.TransactionRequestVO;
import com.topup.charging.dto.TransactionResponseVO;
import com.topup.charging.entity.Transactions;
import com.topup.charging.entity.Wallets;
import com.topup.charging.repository.TransactionsRepository;

import brave.Span;
import brave.Tracer;

@Service
public class TransactionsService {

	@Autowired
	WalletsService walletsService;

	@Autowired
	CurrencyService currencyService;

	@Autowired
	TransactionsRepository transactionsRepistory;
	
	@Autowired
	Tracer tracer;

	public TransactionResponseVO procesTransactrion(TransactionRequestVO request) {
		double totalBalance = 0;
		TransactionResponseVO response = new TransactionResponseVO();
		
		// We fetch the current amount to be charged & the fees if any
		double chargeAmount = request.getAmount();
		String chargeCurrency = request.getCurrency();
		FeesVO feesVO = request.getFees();
		TransactionCustomerVO customer = request.getCustomer();
		double chargeBalance = deductFees(chargeCurrency, chargeAmount, feesVO);

		// Now time to update customer Wallet
		Wallets wallet = walletsService.findWalletById(customer.getWalletId()).orElse(null);
		totalBalance = wallet.getBalance() + chargeBalance;
		wallet.setBalance(totalBalance);
		wallet = walletsService.updateWallet(wallet);

		// Add a new transaction
		Transactions transaction = createTransaction(request, totalBalance);
		transaction = addNewTransaction(transaction);

		// Create response
		response.setAmount(chargeBalance);
		BalanceVO balance = new BalanceVO();
		balance.setTotalAmount(totalBalance);
		response.setBalance(balance);
		response.setChargeId(request.getChargeId());
		response.setCreated(transaction.getCreated().toString());
		response.setCurrency(chargeCurrency);
		response.setCustomer(customer);
		response.setFees(feesVO);
		// Set unique request id which is trace id
		Span span = tracer.currentSpan();
        String traceId = span.context().traceIdString();
		response.setId(traceId);
		response.setStatus(transaction.getStatus());

		return response;

	}

	public Transactions createTransaction(TransactionRequestVO request, double totalBalance) {
		Date date = new Date();
		Transactions transaction = new Transactions();
		transaction.setChargeId(request.getChargeId());
		transaction.setCreated(date);
		transaction.setCustomerId(request.getCustomer().getId());
		transaction.setFinalAmount(totalBalance);
		transaction.setStatus("SUCCESS");
		FeesVO fees = request.getFees();
		if (fees != null) {
			transaction.setFeesAmount(fees.getAmount());
			transaction.setFeesCurrencyId(currencyService.identifyCurrencyId(fees.getCurrency()));
		}
		return transaction;
	}

	public double deductFees(String fromCurrency, double fromCurrencyAmount, FeesVO fees) {
		double result = 0;
		int fromCurrencyId = currencyService.identifyCurrencyId(fromCurrency);

		double fromCurrencyConvertedAmount = currencyService.getConversionRate(fromCurrencyId, fromCurrencyAmount);
		if (fees != null && !fees.getCurrency().isEmpty() && fees.getAmount() > 0) {
			int feesCurrencyId = currencyService.identifyCurrencyId(fees.getCurrency());
			double feesCurrencyConvertedAmount = currencyService.getConversionRate(feesCurrencyId, fees.getAmount());
			result = fromCurrencyConvertedAmount - feesCurrencyConvertedAmount;
		} else {
			result = fromCurrencyConvertedAmount;
		}

		return result;
	}

	public Transactions addNewTransaction(Transactions transaction) {
		return transactionsRepistory.save(transaction);
	}

	public List<Transactions> findAllTransactions(){
		return transactionsRepistory.findAll();
	}
}
