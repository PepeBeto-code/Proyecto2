package com.microservices.shopping.service;

import java.util.List;

import com.microservices.shopping.entity.Invoice;

public interface InvoiceService {
    public List<Invoice> findInvoiceAll();
    public List<Invoice> findByState(String state);
    public Invoice createInvoice(Invoice invoice);
    public Invoice updateInvoice(Invoice invoice);
    public Invoice deleteInvoice(Invoice invoice);
    public Invoice getInvoice(Long id);
    public Long mostRecentId();
}
