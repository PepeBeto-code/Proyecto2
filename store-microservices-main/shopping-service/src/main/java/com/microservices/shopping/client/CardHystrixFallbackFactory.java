package com.microservices.shopping.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.microservices.shopping.model.Card;

@Component
public class CardHystrixFallbackFactory implements CardClient {

	@Override
	public ResponseEntity<Card> getCard(Long id) {
		Card card = Card.builder()
				.number("none")
				.expDate("none")
				.balance(0.0).build();
		return ResponseEntity.ok(card);
	}

	@Override
	public ResponseEntity<Card> updateBalance(Long id, Double value) {
		Card card = Card.builder()
				.number("none")
				.expDate("none")
				.balance(0.0).build();
		return ResponseEntity.ok(card);
	}

}
