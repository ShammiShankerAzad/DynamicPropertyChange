package com.example.demo.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.demo.service.PricingService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/pricing")
@RefreshScope
public class PricingController {
    private final PricingService pricingService;

    public PricingController(PricingService pricingService) {
        System.out.println("Controller refreshed");
        this.pricingService = pricingService;
    }

    @GetMapping("/{basePrice}")
    public ResponseEntity<Double> getDiscountedPrice(@PathVariable double basePrice) {
        double discountedPrice = pricingService.calculatePrice(basePrice);
        return ResponseEntity.ok(discountedPrice);
    }
}

