package com.example.promo_campaign_service.campaign;

import com.example.promo_campaign_service.customer.Customer;
import com.example.promo_campaign_service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class PromoCampaignController {

    private PromoCampaignService service;
    private CustomerService customerService;

    @Autowired
    public PromoCampaignController(PromoCampaignService service,
                                   CustomerService customerService) {
        this.service = Objects.requireNonNull(service,"Promo Campaign Service must be defined");
        this.customerService = Objects.requireNonNull(customerService,
                "Customer Service must be defined");
    }

   @PostMapping("/campaigns")
    public ResponseEntity save(@RequestBody PromoCampaign campaign){
        Optional<Customer> customer = customerService.getCustomerById(campaign.getCustomerId());

        if(customer.isPresent()) {
            if (customer.get().getBrand().equals(campaign.getBrand())){
                service.save(campaign);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.badRequest().body("Invalid customer brand.");
        }
        }else{
            return ResponseEntity.badRequest().body("Invalid customer id");
        }
    }

    @GetMapping("/campaigns")
    public ResponseEntity<List<PromoCampaign>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/campaigns/current/{brand}")
    public ResponseEntity<List<PromoCampaign>> getByBrand(@PathVariable String brand){
        return ResponseEntity.ok(service.getCurrentByBrand(brand));
    }

    @GetMapping("/campaigns/all")
    public ResponseEntity<List<PromoCampaign>> getAllCampaigns(){
        return ResponseEntity.ok(service.getAll());
    }

   /* @GetMapping("campaigns/planning/{brand}")
    public ResponseEntity<List<PromoCampaign>> getByPlannig (@PathVariable String brand){
        return ResponseEntity.ok(service.getPlanningByBrand(brand));
    }

    @GetMapping("campaigns/finished/{brand}")
    public ResponseEntity<List<PromoCampaign>> getByFinished (@PathVariable String brand){
        return ResponseEntity.ok(service.getFinishByBrand(brand));
    }*/
}
