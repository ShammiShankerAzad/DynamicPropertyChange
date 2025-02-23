package com.example.demo.service;

import com.example.demo.config.PricingConfig;
import org.springframework.stereotype.Service;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Service
@RefreshScope
public class PricingService {
    private final PricingConfig config;

    public PricingService(PricingConfig config) {
        System.out.println("Service refreshed");
        this.config = config;
    }

    public double calculatePrice(double basePrice) {
        return basePrice * (1 - config.getDiscountFactor());
    }
}

