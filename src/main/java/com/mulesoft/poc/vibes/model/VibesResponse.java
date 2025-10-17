package com.mulesoft.poc.vibes.model;

import java.time.LocalDateTime;

/**
 * Response model for vibes analysis
 */
public class VibesResponse {
    
    private VibesAnalysis analysis;
    private VibesRecommendations recommendations;

    public VibesResponse() {}

    public VibesResponse(VibesAnalysis analysis, VibesRecommendations recommendations) {
        this.analysis = analysis;
        this.recommendations = recommendations;
    }

    public VibesAnalysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(VibesAnalysis analysis) {
        this.analysis = analysis;
    }

    public VibesRecommendations getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(VibesRecommendations recommendations) {
        this.recommendations = recommendations;
    }

    public static class VibesAnalysis {
        private String text;
        private String sentiment;
        private String vibeIntensity;
        private int wordCount;
        private int characterCount;
        private LocalDateTime timestamp;
        private String confidence;

        public VibesAnalysis() {}

        public VibesAnalysis(String text, String sentiment, String vibeIntensity, 
                           int wordCount, int characterCount, LocalDateTime timestamp, String confidence) {
            this.text = text;
            this.sentiment = sentiment;
            this.vibeIntensity = vibeIntensity;
            this.wordCount = wordCount;
            this.characterCount = characterCount;
            this.timestamp = timestamp;
            this.confidence = confidence;
        }

        // Getters and setters
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
        
        public String getSentiment() { return sentiment; }
        public void setSentiment(String sentiment) { this.sentiment = sentiment; }
        
        public String getVibeIntensity() { return vibeIntensity; }
        public void setVibeIntensity(String vibeIntensity) { this.vibeIntensity = vibeIntensity; }
        
        public int getWordCount() { return wordCount; }
        public void setWordCount(int wordCount) { this.wordCount = wordCount; }
        
        public int getCharacterCount() { return characterCount; }
        public void setCharacterCount(int characterCount) { this.characterCount = characterCount; }
        
        public LocalDateTime getTimestamp() { return timestamp; }
        public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
        
        public String getConfidence() { return confidence; }
        public void setConfidence(String confidence) { this.confidence = confidence; }
    }

    public static class VibesRecommendations {
        private String musicGenre;
        private String mood;
        private String suggestedActivity;

        public VibesRecommendations() {}

        public VibesRecommendations(String musicGenre, String mood, String suggestedActivity) {
            this.musicGenre = musicGenre;
            this.mood = mood;
            this.suggestedActivity = suggestedActivity;
        }

        // Getters and setters
        public String getMusicGenre() { return musicGenre; }
        public void setMusicGenre(String musicGenre) { this.musicGenre = musicGenre; }
        
        public String getMood() { return mood; }
        public void setMood(String mood) { this.mood = mood; }
        
        public String getSuggestedActivity() { return suggestedActivity; }
        public void setSuggestedActivity(String suggestedActivity) { this.suggestedActivity = suggestedActivity; }
    }
}