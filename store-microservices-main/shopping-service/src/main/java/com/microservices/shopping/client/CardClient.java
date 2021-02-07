package com.microservices.shopping.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.shopping.model.Card;

@FeignClient(name = "payment-service", 
			 fallback = CardHystrixFallbackFactory.class)
public interface CardClient {
	
	@GetMapping(value = "/payments/{id}")
	public ResponseEntity<Card> getCard(@PathVariable(name = "id") Long id);
	
	@PutMapping(value = "/payments/{id}/balance")
	public ResponseEntity<Card> updateBalance(@PathVariable(name = "id") Long id, @RequestParam(name = "value", required = true) Double value);
}
