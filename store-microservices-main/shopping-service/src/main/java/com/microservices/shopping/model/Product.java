package com.microservices.shopping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@AllArgsConstructor 
@ToString 
@EqualsAndHashCode
@Builder
@NoArgsConstructor
public class Product {
	private Long id;
    private String name;
    private String description;
    private Double stock;
    private Double price;
    private String status;
    private Category category;
}
