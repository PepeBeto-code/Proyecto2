package com.microservices.payment.service;

import java.util.ArrayList;
import java.util.List;

import com.microservices.payment.entity.*;

public interface PaymentService {
	
	   // public List<Card> findCustomerAll();
	public Card createCard(Card customer);
	   // public Card updateCustomer(Card customer);
    public void deleteCard(Long customer);
	public ArrayList<Card> findByCustomer(Long idCustomer);
	public ArrayList<Card> listAllProduct();
	public Card getCard(Long id);
}
