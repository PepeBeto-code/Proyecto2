package com.microservices.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.customer.entity.Customer;
import com.microservices.customer.entity.Region;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer,Long> {
        public Customer findByNumberID(String numberID);
        public List<Customer> findByLastName(String lastName);
        public List<Customer> findByRegion(Region region);
}
