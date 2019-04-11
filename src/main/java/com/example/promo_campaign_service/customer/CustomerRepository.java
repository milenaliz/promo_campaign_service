package com.example.promo_campaign_service.customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findAll();

    boolean existsByEmail(String email);

    Customer findByEmail (String email);
}
