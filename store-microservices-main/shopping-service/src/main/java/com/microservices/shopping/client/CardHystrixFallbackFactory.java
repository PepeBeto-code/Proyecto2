package com.microservices.shopping.client;

import org.springframework.http.ResponseEntity;

import com.microservices.shopping.model.Card;

public class CardHystrixFallbackFactory implements CardClient {

	@Override
	public ResponseEntity<Card> getCard(Long id) {
		Card card = Card.builder()
				.number("none")
				.expDate("none")
				.balance(0.0).build();
		return ResponseEntity.ok(card);
	}

}
