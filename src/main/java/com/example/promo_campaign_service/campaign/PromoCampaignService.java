package com.example.promo_campaign_service.campaign;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PromoCampaignService {
    private PromoCampaignRepository repository;

    public PromoCampaignService(PromoCampaignRepository repository) {
        this.repository = Objects.requireNonNull(repository,
                "Campaign repository must be defined");
    }

    public void save(PromoCampaign campaign) {
        repository.save(campaign);
    }

    public List<PromoCampaign> getAll() {
        return repository.findAll();
    }

    public List<PromoCampaign> getCurrentByBrand(String brand) {
        return repository.findByBrandAndStartBefore(brand, LocalDate.now());
    }
}


    //private List<PromoCampaign> campaigns = new ArrayList<>();



   /* public void save (PromoCampaign campaign){
        campaigns.add(campaign);
    }*/


    /*public List<PromoCampaign> getAll(){
        return campaigns;
    }

    public List<PromoCampaign> getCurrentByBrand(String brand){
        return campaigns.stream()
                .filter(campaign -> campaign.getBrand().equals(brand))
                .filter(campaign -> campaign.getStart().isBefore(LocalDate.now()))
                .filter(campaign -> campaign.getEnd().isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public List<PromoCampaign> getPlanningByBrand(String brand){
        return campaigns.stream()
                .filter(campaign -> campaign.getBrand().equals(brand))
                .filter(campaign -> campaign.getStart().isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public List<PromoCampaign> getFinishByBrand(String brand){
        return campaigns.stream()
                .filter(campaign -> campaign.getBrand().equals(brand))
                .filter(campaign -> campaign.getEnd().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }*/

