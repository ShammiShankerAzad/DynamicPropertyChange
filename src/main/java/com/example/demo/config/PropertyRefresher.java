package com.example.demo.config;

import com.example.demo.service.PricingService;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PropertyRefresher {
    private final ContextRefresher contextRefresher;
    private final PricingService pricingService;

    public PropertyRefresher(ContextRefresher contextRefresher, PricingService pricingService) {
        this.contextRefresher = contextRefresher;
        this.pricingService = pricingService;
    }

    @Scheduled(fixedRate = 300000) // Run every 5 minutes
    public void refreshProperties() {
        contextRefresher.refresh();
        System.out.println("Properties refreshed. New discount factor: " +
                pricingService.calculatePrice(100)); // Example calculation
    }
}

