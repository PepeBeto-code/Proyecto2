package com.microservices.shopping.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.microservices.shopping.model.Product;
@Component
public class ProductHystrixFallbackFactory implements ProductClient {
	@Override
	public ResponseEntity<Product> getProduct(Long id) {
		Product customer = Product.builder()
                .name("none")
                .description("none")
                .stock(0.00)
                .status("none")
                .category(null)
                .price(0.00).build();
        return ResponseEntity.ok(customer);
	}
	@Override
	public ResponseEntity<Product> updateStockProduct(Long id, Double quantity) {
		Product customer = Product.builder()
                .name("none")
                .description("none")
                .stock(0.00)
                .status("none")
                .category(null)
                .price(0.00).build();
        return ResponseEntity.ok(customer);
   }
}
