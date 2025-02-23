package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Configuration
@RefreshScope
public class PricingConfig {
    @Value("#{systemProperties['pricing.discountFactor'] ?: 0.1}")
    private double discountFactor;

    public double getDiscountFactor() {
        return discountFactor;
    }
}

