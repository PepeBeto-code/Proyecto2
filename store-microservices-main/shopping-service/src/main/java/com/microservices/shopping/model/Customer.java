package com.microservices.shopping.model;

import java.util.List;

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
public class Customer {
	private Long id;
    private String numberID;
    private String firstName;
    private String lastName;
    private String email;
    private String photoUrl;
    private Region region;
    private String state;
    private List<Card> cards;

}
