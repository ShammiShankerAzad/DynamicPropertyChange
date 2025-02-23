package com.example.demo.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.cloud.context.refresh.ContextRefresher;
import java.util.Random;

@Component
public class SystemPropertyUpdater {
    private final ContextRefresher contextRefresher;
    private final Random random = new Random();

    public SystemPropertyUpdater(ContextRefresher contextRefresher) {
        this.contextRefresher = contextRefresher;
    }

    @Scheduled(fixedRate = 30000) // Run every minute
    public void updateDiscountFactor() {
        double newDiscountFactor = random.nextDouble(0.5); // Random discount between 0 and 0.5
        System.setProperty("pricing.discountFactor", String.valueOf(newDiscountFactor));
        contextRefresher.refresh();
        System.out.println("Updated discount factor to: " + newDiscountFactor);
    }
}

