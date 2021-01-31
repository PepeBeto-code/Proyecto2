package com.microservices.customer.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microservices.customer.model.Card;

@FeignClient(name = "payment-service")
@RequestMapping(value = "/cards")
public interface CardClient {
	
	@GetMapping(value = "/byCustomer/{idCustomer}")
	public ResponseEntity<List<Card>> getCards(@PathVariable("id_customer") Long id);

}
