package com.mulesoft.poc.vibes.service;

import com.mulesoft.poc.vibes.model.HealthResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Service for health check functionality
 * Demonstrates the same monitoring patterns used in MuleSoft
 */
@Service
public class HealthService {

    @Value("${app.name:vibes-poc}")
    private String appName;

    @Value("${app.version:1.0.0}")
    private String appVersion;

    public HealthResponse getHealthStatus() {
        return new HealthResponse(
            "healthy",
            appName,
            LocalDateTime.now(),
            appVersion
        );
    }
}