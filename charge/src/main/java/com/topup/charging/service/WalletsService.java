package com.topup.charging.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topup.charging.entity.Wallets;
import com.topup.charging.repository.WalletsRepository;

@Service
public class WalletsService {

	@Autowired
	WalletsRepository walletsRepository;

	public List<Wallets> findAllWallets() {
		return walletsRepository.findAll();
	}

	public Wallets addNewWallet(Wallets wallet) {
		UUID uuid = UUID.randomUUID();
		wallet.setWalletId(uuid.toString());
		return walletsRepository.save(wallet);
	}

	public List<Wallets> findWalletsByCustomerId(String customerId) {
		return walletsRepository.findByCustomerId(customerId);
	}

	public Optional<Wallets> findWalletById(String walletId) {
		return walletsRepository.findById(walletId);
	}

	public void deleteWallet(String walletId) {
		walletsRepository.deleteById(walletId);
	}
	
	public Wallets updateWallet (Wallets wallet) {
		return walletsRepository.save(wallet);
	}
}
