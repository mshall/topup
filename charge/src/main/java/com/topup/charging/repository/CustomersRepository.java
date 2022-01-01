package com.topup.charging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topup.charging.entity.Customers;

@Repository
public interface CustomersRepository  extends JpaRepository<Customers, String> {

}
