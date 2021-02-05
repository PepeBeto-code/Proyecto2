package com.microservices.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.microservices.shopping.model.Customer;
import com.microservices.shopping.model.Customer;

import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "number_invoice")
	private String numberInvoice;

	@Column(name = "pay_method")
	private String payMethod;

	@Column(name = "number_card")
	private String numberCard;

	private String description;

	@Column(name = "customer_id")
	private Long customerId;

<<<<<<< HEAD
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@Valid
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "invoice_id")
	private List<InvoiceItem> items;

	private String state;
=======
    @Valid
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private List<InvoiceItem> items;
>>>>>>> 189cc5a5c258501d5d9603b5f59dba68dfa3ace1

	@Transient
	private Customer customer;

	public Invoice() {
		items = new ArrayList<>();
	}

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

}
