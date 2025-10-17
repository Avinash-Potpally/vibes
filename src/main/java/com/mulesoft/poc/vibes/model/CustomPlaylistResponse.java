package com.mulesoft.poc.vibes.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Response model for custom playlist
 */
public class CustomPlaylistResponse {
    
    private CustomPlaylist customPlaylist;

    public CustomPlaylistResponse() {}

    public CustomPlaylistResponse(CustomPlaylist customPlaylist) {
        this.customPlaylist = customPlaylist;
    }

    public CustomPlaylist getCustomPlaylist() {
        return customPlaylist;
    }

    public void setCustomPlaylist(CustomPlaylist customPlaylist) {
        this.customPlaylist = customPlaylist;
    }

    public static class CustomPlaylist {
        private String mood;
        private String genre;
        private LocalDateTime generatedAt;
        private List<String> tracks;
        private String estimatedDuration;
        private PlaylistRecommendations recommendations;

        public CustomPlaylist() {}

        public CustomPlaylist(String mood, String genre, LocalDateTime generatedAt, 
                            List<String> tracks, String estimatedDuration, PlaylistRecommendations recommendations) {
            this.mood = mood;
            this.genre = genre;
            this.generatedAt = generatedAt;
            this.tracks = tracks;
            this.estimatedDuration = estimatedDuration;
            this.recommendations = recommendations;
        }

        // Getters and setters
        public String getMood() { return mood; }
        public void setMood(String mood) { this.mood = mood; }
        
        public String getGenre() { return genre; }
        public void setGenre(String genre) { this.genre = genre; }
        
        public LocalDateTime getGeneratedAt() { return generatedAt; }
        public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }
        
        public List<String> getTracks() { return tracks; }
        public void setTracks(List<String> tracks) { this.tracks = tracks; }
        
        public String getEstimatedDuration() { return estimatedDuration; }
        public void setEstimatedDuration(String estimatedDuration) { this.estimatedDuration = estimatedDuration; }
        
        public PlaylistRecommendations getRecommendations() { return recommendations; }
        public void setRecommendations(PlaylistRecommendations recommendations) { this.recommendations = recommendations; }
    }

    public static class PlaylistRecommendations {
        private List<String> similar;
        private String nextSuggestion;

        public PlaylistRecommendations() {}

        public PlaylistRecommendations(List<String> similar, String nextSuggestion) {
            this.similar = similar;
            this.nextSuggestion = nextSuggestion;
        }

        public List<String> getSimilar() { return similar; }
        public void setSimilar(List<String> similar) { this.similar = similar; }
        
        public String getNextSuggestion() { return nextSuggestion; }
        public void setNextSuggestion(String nextSuggestion) { this.nextSuggestion = nextSuggestion; }
    }
}