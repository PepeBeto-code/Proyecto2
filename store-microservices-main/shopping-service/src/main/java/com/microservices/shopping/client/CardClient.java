package com.microservices.shopping.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microservices.shopping.model.Card;

@FeignClient(name = "payment-service", 
			 fallback = CardHystrixFallbackFactory.class)
@RequestMapping("/cards")
public interface CardClient {
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Card> getCard(Long id);

}
