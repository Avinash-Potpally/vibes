package com.mulesoft.poc.vibes.model;

import java.time.LocalDateTime;

/**
 * Health check response model
 */
public class HealthResponse {
    
    private String status;
    private String service;
    private LocalDateTime timestamp;
    private String version;

    public HealthResponse() {}

    public HealthResponse(String status, String service, LocalDateTime timestamp, String version) {
        this.status = status;
        this.service = service;
        this.timestamp = timestamp;
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}