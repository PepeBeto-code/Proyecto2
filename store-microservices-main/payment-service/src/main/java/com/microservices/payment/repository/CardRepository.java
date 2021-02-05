package com.microservices.payment.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservices.payment.entity.Card;

@Repository
public interface CardRepository  extends JpaRepository<Card,Long> {
	
	public  ArrayList<Card>  findAll();
	@Query("SELECT a FROM Card a WHERE a.id_customer=?1")
	public ArrayList<Card> findByCustomer(Long idCustomer);
}
