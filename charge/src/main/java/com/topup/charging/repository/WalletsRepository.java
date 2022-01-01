package com.topup.charging.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topup.charging.entity.Wallets;

@Repository
public interface WalletsRepository  extends JpaRepository<Wallets, String> {
	List<Wallets> findByCustomerId(String customerId);
}
