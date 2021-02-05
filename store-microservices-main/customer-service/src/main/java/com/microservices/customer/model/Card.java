package com.microservices.customer.model;


import lombok.Data;

@Data
public class Card {
	private Long id;
	private String number;
	private String exp_date;
	private String cvv;
	private Double balance;
	private Bank bank;
}
