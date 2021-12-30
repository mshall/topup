package com.topup.charging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topup.charging.entity.Currency;

@Repository
public interface CurrencyRepository  extends JpaRepository<Currency, Integer> {

}
