package de.rboerner.springdemo.health;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {

    @Value("#{environment.FABENV ?: 'N/A'}")
    private String environment;

    @Override
    public Health health() {
        switch (environment) {
            case "PROD":
            case "ITDC":
                return Health.up().withDetail("environment.FABENV", environment).build();
            case "N/A":
            case "DEVEL":
            default:
                return Health.outOfService().withDetail("environment.FABENV", environment).build();
        }
    }
}
