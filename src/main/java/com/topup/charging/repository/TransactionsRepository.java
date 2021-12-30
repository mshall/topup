package com.topup.charging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topup.charging.entity.Transactions;

@Repository
public interface TransactionsRepository  extends JpaRepository<Transactions, Integer> {

}
