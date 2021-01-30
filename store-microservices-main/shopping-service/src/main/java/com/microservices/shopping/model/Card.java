package com.microservices.shopping.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Card {
	private Long id;
	private String number;
	private String expDate;
	private String cvv;
	private Double balance;
	private Bank bank;
}
