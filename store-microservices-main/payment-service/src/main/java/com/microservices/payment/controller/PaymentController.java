package com.microservices.payment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.payment.entity.Card;
import com.microservices.payment.service.PaymentService;
import com.microservices.payment.controller.ErrorMessage;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	
	 @GetMapping(value = "/{id}")
	    public ResponseEntity<Card> getProduct(@PathVariable("id") Long id) {
	        Card card =  paymentService.getCard(id);
	        if (null==card){
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(card);
	    }
	 
	   @GetMapping
	    public ResponseEntity<List<Card>> listProduct(@RequestParam(name = "customerId", required = false) Long customerId){
	        List<Card> cards = new ArrayList<>();
	        if (null ==  customerId){
	        	cards = paymentService.listAllProduct();
	            if (cards.isEmpty()){
	                return ResponseEntity.noContent().build();
	            }
	        }else{
	        	cards = paymentService.findByCustomer(customerId);
	            if (cards.isEmpty()){
	                return ResponseEntity.notFound().build();
	            }
	        }
	        
	        return ResponseEntity.ok(cards);

     }
	   
	   @PostMapping
	    public ResponseEntity<Card> createProduct(@Valid @RequestBody Card card, BindingResult result){
	        if (result.hasErrors()){
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
	        }
	        Card cardCreate =  paymentService.createCard(card);
	        return ResponseEntity.status(HttpStatus.CREATED).body(cardCreate);
	    }
	   
	    @DeleteMapping(value = "/{id}")
	    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
	        paymentService.deleteCard(id);
	        return new ResponseEntity<>("Se a eliminado exitosamente",HttpStatus.OK);
	    }
	    
	    private String formatMessage( BindingResult result){
	        List<Map<String,String>> errors = result.getFieldErrors().stream()
	                .map(err ->{
	                    Map<String,String>  error =  new HashMap<>();
	                    error.put(err.getField(), err.getDefaultMessage());
	                    return error;

	                }).collect(Collectors.toList());
	        ErrorMessage errorMessage = ErrorMessage.builder()
	                .code("01")
	                .messages(errors).build();
	        ObjectMapper mapper = new ObjectMapper();
	        String jsonString="";
	        try {
	            jsonString = mapper.writeValueAsString(errorMessage);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }
	        return jsonString;
	    }
}
