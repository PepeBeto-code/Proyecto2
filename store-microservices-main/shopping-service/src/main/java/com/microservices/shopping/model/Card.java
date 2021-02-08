package com.microservices.shopping.model;


import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty(value = "num")
	private String number;
	private String exp_date;
	private String cvv;
	private Double balance;
	private Long id_customer;
	private Bank bank;
}
