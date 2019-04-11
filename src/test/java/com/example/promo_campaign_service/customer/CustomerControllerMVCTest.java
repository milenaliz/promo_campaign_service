package com.example.promo_campaign_service.customer;

import com.example.promo_campaign_service.campaign.PromoCampaignService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerService.class)
public class CustomerControllerMVCTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private  CustomerService service;

    @Test
    public void getAllCustomers () throws Exception {
       List<Customer> customers = new ArrayList<>();



    }
}
