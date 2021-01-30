package com.microservices.shopping.client;

import org.springframework.http.ResponseEntity;

import com.microservices.shopping.model.Product;

public class ProductHystrixFallBackFactory implements ProductClient {

	@Override
	public ResponseEntity<Product> getProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Product> updateStockProduct(Long id, Double quantity) {
		// TODO Auto-generated method stub
		return null;
	}

}
