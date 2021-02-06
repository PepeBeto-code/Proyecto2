package com.microservices.payment.service;

import java.util.ArrayList;
import org.springframework.security.crypto.password.PasswordEncoder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.payment.entity.Card;
import com.microservices.payment.repository.CardRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	CardRepository cardRepository; 
	
    public  Card getCard(Long id) {
    	return cardRepository.findById(id).orElse(null);
    }
    
    public ArrayList<Card> listAllProduct(){
        return cardRepository.findAll();

    }
    
    public ArrayList<Card> findByCustomer(Long idCustomer){
    	return cardRepository.findByCustomer(idCustomer);
    }
    
    public void deleteCard(Long customer) { 
        this.cardRepository.deleteById(customer);
    }
    
    @Override
    public Card updateCard(Card card) {
    	Card cardDB =  cardRepository.findById(card.getId()).orElse(null);
    	System.out.println("es es el card: "+cardDB);
        if (cardDB == null){
            return  null;
        }
        cardDB.setNumber(card.getNumber());
        cardDB.setExp_date(card.getExp_date());
        return cardRepository.save(cardDB);
    }
    
	public Card createCard(Card card) {
		Card cardDB = cardRepository.findById (card.getId()).orElse(null);
	        if (cardDB != null){
	            return  cardDB;
	        }
	    card.setCvv(this.passwordEncoder.encode(card.getCvv()));
		return cardRepository.save(card);
	}

	@Override
	public Card updateBalance(Long id, Double value) {
		Card cardDB = this.getCard(id);
		if (null == cardDB) {
			return null;
		}
		Double balance = cardDB.getBalance() + value;
		cardDB.setBalance(balance);
		return this.cardRepository.save(cardDB);
	}



}
