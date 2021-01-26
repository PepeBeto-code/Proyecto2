package com.microservices.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.shopping.entity.InvoiceItem;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem,Long> {
}
