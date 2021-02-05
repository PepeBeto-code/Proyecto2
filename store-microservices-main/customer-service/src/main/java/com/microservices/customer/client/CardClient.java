package com.microservices.customer.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.customer.model.Card;

@FeignClient(name = "payment-service", fallback = CardHystrixFallbackFactory.class)
public interface CardClient {
	
	 @GetMapping(value = "/payments")
	 public ResponseEntity<List<Card>> listCard(@RequestParam(name = "customerId", required = false) Long customerId);
}
