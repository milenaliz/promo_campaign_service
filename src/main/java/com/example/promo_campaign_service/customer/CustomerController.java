package com.example.promo_campaign_service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class CustomerController {

    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = Objects.requireNonNull(service,
                "Customer service must be defined.");
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> save (@RequestBody Customer customer){
        if(service.existByEmail(customer.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(service.save(customer));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/customers/{email}")
    public ResponseEntity<Customer> getByEmail(@PathVariable String email){
        return ResponseEntity.ok(service.getCustomerByEmail(email));
    }
}
