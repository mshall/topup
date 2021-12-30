package com.topup.charging.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name, symbol;
	private double value;
}
