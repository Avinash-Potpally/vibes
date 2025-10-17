package com.mulesoft.poc.vibes.model;

import javax.validation.constraints.NotBlank;

/**
 * Request model for custom playlist creation
 */
public class CustomPlaylistRequest {
    
    @NotBlank(message = "Mood is required")
    private String mood;
    
    private String genre;

    public CustomPlaylistRequest() {}

    public CustomPlaylistRequest(String mood, String genre) {
        this.mood = mood;
        this.genre = genre;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}