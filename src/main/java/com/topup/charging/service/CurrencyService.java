package com.topup.charging.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topup.charging.entity.Currency;
import com.topup.charging.entity.Wallets;
import com.topup.charging.repository.CurrencyRepository;

@Service
public class CurrencyService {

	@Autowired
	CurrencyRepository currencyRepository;

	public List<Currency> findAllCurrencies() {
		return currencyRepository.findAll();
	}

	public Currency addNewCurrency(Currency currency) {
		return currencyRepository.save(currency);
	}

	public Optional<Currency> findCurrencyById(int currencyId) {
		return currencyRepository.findById(currencyId);
	}

	public void deleteCurrency(int currencyId) {
		currencyRepository.deleteById(currencyId);
	}

	public double getConversionRate(int currencyId, double amount) {
		Optional<Currency> fromCurrency = findCurrencyById(currencyId);
		double fromCurrencyValue = fromCurrency.orElse(null).getValue();
		double result = amount * fromCurrencyValue;
		return result;
	}

	public int identifyCurrencyId(String currencyName) {
		int currencyId = 0;
		switch (currencyName.toUpperCase()) {
		case "USD":
			currencyId = 1;
			break;
		case "KWD":
			currencyId = 2;
			break;
		case "AED":
			currencyId = 3;
			break;

		case "EGP":
			currencyId = 4;
			break;
		default:
			currencyId = 0;
			break;
		}
		return currencyId;
	}
}
