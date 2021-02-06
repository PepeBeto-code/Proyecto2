package com.microservices.shopping.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.shopping.client.CardClient;
import com.microservices.shopping.client.CustomerClient;
import com.microservices.shopping.client.ProductClient;
//import com.microservices.shopping.client.CustomerClient;
//import com.microservices.shopping.client.ProductClient;
import com.microservices.shopping.entity.Invoice;
import com.microservices.shopping.entity.InvoiceItem;
import com.microservices.shopping.model.Card;
import com.microservices.shopping.model.Customer;
import com.microservices.shopping.model.Product;
//import com.microservices.shopping.model.Customer;
//import com.microservices.shopping.model.Product;
import com.microservices.shopping.repository.InvoiceItemsRepository;
import com.microservices.shopping.repository.InvoiceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    InvoiceItemsRepository invoiceItemsRepository;
    
    @Autowired
    CustomerClient customerClient;

    @Autowired
    ProductClient productClient;
    
    @Autowired
    CardClient cardClient;

    @Override
    public List<Invoice> findInvoiceAll() {
        return  invoiceRepository.findAll();
    }


    @Override
    public Invoice createInvoice(Invoice invoice) {
        Invoice invoiceDB = invoiceRepository.findByNumberInvoice ( invoice.getNumberInvoice () );
        if (invoiceDB !=null){
            return  invoiceDB;
        } 
        invoice.setState("CREATED");
        List<InvoiceItem> items = invoice.getItems();
        items.forEach( invoiceItem -> {
            productClient.updateStockProduct( invoiceItem.getProductId(), invoiceItem.getQuantity() * -1);
        });
        
        double total = 0.0;
        for(int i = 0; i < items.size(); i++) {
        	total = total + items.get(i).getSubTotal();
        }
        invoice.setTotal(total);
        String cardNumber = invoice.getCard().getNumber();
        invoice.setNumberCard(cardNumber.substring(cardNumber.length() - 4));
        
        if(invoice.getPayMethod() == "tarjeta") {
        	if (invoice.getCustomer().getCards() == null || invoice.getCustomer().getCards().isEmpty()) {
        		invoice.setPayMethod("efectivo");
        		invoice.setNumberCard("");
        	} else {
            	Card card = cardClient.updateBalance(invoice.getCard().getId(), -1 * total).getBody();
            	if (card.getId() == null && card.getNumber() == "none" && card.getExp_date() == "none") {
         	        invoice.setPayMethod("efectivo");
         	        invoice.setNumberCard("");
         	    } 
        	}	
        }
        
        invoiceDB = invoiceRepository.save(invoice);
        return invoiceDB;
    }


    @Override
    public Invoice updateInvoice(Invoice invoice) {
        Invoice invoiceDB = getInvoice(invoice.getId());
        if (invoiceDB == null){
            return  null;
        }
        invoiceDB.setCustomerId(invoice.getCustomerId());
        invoiceDB.setDescription(invoice.getDescription());
        invoiceDB.setPayMethod(invoice.getPayMethod());
        invoiceDB.setNumberCard(invoice.getNumberCard());
        invoiceDB.setNumberInvoice(invoice.getNumberInvoice());
        invoiceDB.getItems().clear();
        invoiceDB.setItems(invoice.getItems());
        return invoiceRepository.save(invoiceDB);
    }


    @Override
    public Invoice deleteInvoice(Invoice invoice) {
        Invoice invoiceDB = getInvoice(invoice.getId());
        if (invoiceDB == null){
            return  null;
        }
        invoiceDB.setState("DELETED");
        return invoiceRepository.save(invoiceDB);
    }

    @Override
    public Invoice getInvoice(Long id) {

        Invoice invoice= invoiceRepository.findById(id).orElse(null);
        if (null != invoice ){
        	System.out.println("Id del customer:" + invoice.getCustomerId());
            Customer customer = customerClient.getCustomer(invoice.getCustomerId()).getBody();
        	System.out.println("este es el costumer: "+customer);
            invoice.setCustomer(customer);
            List<InvoiceItem> listItem=invoice.getItems().stream().map(invoiceItem -> {
                Product product = productClient.getProduct(invoiceItem.getProductId()).getBody();
                invoiceItem.setProduct(product);
                return invoiceItem; 
            }).collect(Collectors.toList());
            invoice.setItems(listItem);
        }
        return invoice ;
    }
}
