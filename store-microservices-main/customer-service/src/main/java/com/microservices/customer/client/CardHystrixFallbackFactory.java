package com.microservices.customer.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.microservices.customer.model.Card;

@Component
public class CardHystrixFallbackFactory implements CardClient {

	@Override
	public ResponseEntity<List<Card>> listCard(Long customerId) {
		return ResponseEntity.ok(null);
	}

}
