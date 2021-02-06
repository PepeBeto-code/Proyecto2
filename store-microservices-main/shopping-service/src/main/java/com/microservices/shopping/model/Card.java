package com.microservices.shopping.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@AllArgsConstructor 
@ToString 
@EqualsAndHashCode
@Builder
@NoArgsConstructor
public class Card {
	private Long id;
	private String number;
	private String exp_date;
	private String cvv;
	private Double balance;
	private Long id_customer;
	private Bank bank;
}
