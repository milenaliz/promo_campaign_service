package com.example.promo_campaign_service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    // private List<Customer> customers = new ArrayList<>();

    //  private Integer id = 0; //TODO: To remove!!!

    private CustomerRepository repository;
    private RoleRepository roleRepository;

    @Autowired
    CustomerService(CustomerRepository repository,
                    RoleRepository roleRepository) {
        this.repository = Objects.requireNonNull(repository,
                "Customer service must be defined");
        this.roleRepository = Objects.requireNonNull(roleRepository,
                "Role repository must be defined");
    }

    public Customer save(Customer customer) {
        Optional<Role> role = roleRepository.findByName("ROLE_USER");
        role.ifPresent(roleUser -> customer.setRoles
                (new HashSet<>(Arrays.asList(roleUser))));
        return repository.save(customer);
    }

    public List<Customer> getAll() {
        return repository.findAll();
    }

    public boolean existByEmail(String email) {
        return repository.existsByEmail(email);
    }

    public Optional<Customer> getCustomerById(Integer id) {
        return repository.findById(id);
    }

    public Customer getCustomerByEmail(String email) {
       return repository.findByEmail(email);
    }
}
    /*public Customer save(Customer customer){
        customer.setId(++id);
        customers.add(customer);

        return customer;
    }*/

    /*public Optional<Customer> getCustomerById(Integer id){
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }*/

