package com.microservices.customer.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Card {
	private Long id;
	@JsonProperty(value = "num")
	private String number;
	private String exp_date;
	private String cvv;
	private Double balance;
	private Long id_customer;
	private Bank bank;
}
