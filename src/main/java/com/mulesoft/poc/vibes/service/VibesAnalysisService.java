package com.mulesoft.poc.vibes.service;

import com.mulesoft.poc.vibes.model.VibesResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Service for vibes and sentiment analysis
 * Demonstrates the same data transformation patterns used in MuleSoft DataWeave
 */
@Service
public class VibesAnalysisService {

    private static final List<String> POSITIVE_WORDS = Arrays.asList(
        "happy", "joy", "love", "amazing", "great", "wonderful", 
        "fantastic", "excellent", "awesome", "good", "excited", 
        "brilliant", "perfect", "beautiful", "delighted"
    );

    private static final List<String> NEGATIVE_WORDS = Arrays.asList(
        "sad", "angry", "hate", "terrible", "awful", "horrible", 
        "bad", "worst", "disappointed", "upset", "frustrated", 
        "annoyed", "disgusted", "depressed", "miserable"
    );

    public VibesResponse analyzeVibes(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Text input cannot be empty");
        }

        String lowerText = text.toLowerCase();
        int textLength = text.length();
        int wordCount = text.trim().split("\\s+").length;

        // Calculate sentiment
        String sentiment = calculateSentiment(lowerText);
        
        // Calculate vibe intensity
        String vibeIntensity = calculateVibeIntensity(text, textLength);
        
        // Calculate confidence
        String confidence = calculateConfidence(textLength);

        // Create analysis object
        VibesResponse.VibesAnalysis analysis = new VibesResponse.VibesAnalysis(
            text,
            sentiment,
            vibeIntensity,
            wordCount,
            textLength,
            LocalDateTime.now(),
            confidence
        );

        // Create recommendations
        VibesResponse.VibesRecommendations recommendations = new VibesResponse.VibesRecommendations(
            getMusicGenreForSentiment(sentiment),
            sentiment,
            getSuggestedActivityForSentiment(sentiment)
        );

        return new VibesResponse(analysis, recommendations);
    }

    private String calculateSentiment(String lowerText) {
        long positiveCount = POSITIVE_WORDS.stream()
            .mapToLong(word -> countOccurrences(lowerText, word))
            .sum();

        long negativeCount = NEGATIVE_WORDS.stream()
            .mapToLong(word -> countOccurrences(lowerText, word))
            .sum();

        // Enhanced scoring algorithm
        double baseScore = positiveCount - negativeCount;
        
        // If we have a clear majority of positive or negative words
        if (positiveCount > 0 && negativeCount == 0) {
            return "positive";
        } else if (negativeCount > 0 && positiveCount == 0) {
            return "negative";
        } else if (positiveCount > negativeCount) {
            return "positive";
        } else if (negativeCount > positiveCount) {
            return "negative";
        } else {
            return "neutral";
        }
    }

    private String calculateVibeIntensity(String text, int textLength) {
        long exclamationCount = text.chars().filter(ch -> ch == '!').count();
        long capsCount = text.chars().filter(ch -> Character.isUpperCase(ch)).count();
        
        double intensity = (exclamationCount * 2.0 + capsCount / (double) textLength * 10.0);

        if (intensity > 5.0) {
            return "high";
        } else if (intensity > 2.0) {
            return "medium";
        } else {
            return "low";
        }
    }

    private String calculateConfidence(int textLength) {
        if (textLength > 50) {
            return "high";
        } else if (textLength > 20) {
            return "medium";
        } else {
            return "low";
        }
    }

    private String getMusicGenreForSentiment(String sentiment) {
        switch (sentiment) {
            case "positive":
                return "upbeat";
            case "negative":
                return "mellow";
            default:
                return "ambient";
        }
    }

    private String getSuggestedActivityForSentiment(String sentiment) {
        switch (sentiment) {
            case "positive":
                return "dancing";
            case "negative":
                return "relaxation";
            default:
                return "meditation";
        }
    }

    private long countOccurrences(String text, String word) {
        return (text.length() - text.replace(word, "").length()) / word.length();
    }
}