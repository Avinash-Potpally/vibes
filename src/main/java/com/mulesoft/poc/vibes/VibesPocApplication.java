package com.mulesoft.poc.vibes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MuleSoft Vibes POC Application
 * 
 * A Spring Boot application demonstrating MuleSoft integration patterns
 * including sentiment analysis, music recommendations, and error handling.
 * 
 * This POC showcases the same concepts that would be implemented in MuleSoft
 * using a more accessible Spring Boot framework for demonstration purposes.
 */
@SpringBootApplication
public class VibesPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(VibesPocApplication.class, args);
    }
}