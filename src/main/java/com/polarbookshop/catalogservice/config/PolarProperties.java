package com.polarbookshop.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "polar")
public class PolarProperties {
    /**
     * A message to welcome users.
     */
    private String greeting;

    /**
     * Load test data on boot.
     */
    private boolean loadTestData;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public boolean getLoadTestData() {
        return loadTestData;
    }

    public void setLoadTestData(boolean loadTestData) {
        this.loadTestData = loadTestData;
    }
}
