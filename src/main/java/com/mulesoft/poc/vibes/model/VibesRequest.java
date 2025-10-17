package com.mulesoft.poc.vibes.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Request model for vibes analysis
 */
public class VibesRequest {
    
    @NotBlank(message = "Text input is required")
    @Size(min = 1, max = 5000, message = "Text must be between 1 and 5000 characters")
    private String text;

    public VibesRequest() {}

    public VibesRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}