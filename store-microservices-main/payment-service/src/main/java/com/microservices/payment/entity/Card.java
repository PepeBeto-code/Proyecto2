package com.microservices.payment.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class Card implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "number")
	private Double number;
	
	@Column(name = "exp_date")
	private Date exp_date;
	
	@Column(name = "cvv")
	private String cvv;
	
	@NotNull(message = "El banco no puede ser vacio")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bank_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Bank bank;
	
	@Column(name = "id_customer")
	private Long id_customer;
}
