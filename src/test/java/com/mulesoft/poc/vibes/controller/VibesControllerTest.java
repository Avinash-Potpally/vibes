package com.mulesoft.poc.vibes.controller;

import com.mulesoft.poc.vibes.model.*;
import com.mulesoft.poc.vibes.service.VibesAnalysisService;
import com.mulesoft.poc.vibes.service.MusicRecommendationService;
import com.mulesoft.poc.vibes.service.HealthService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for the Vibes POC services
 * Demonstrates the same testing patterns that would be used for MuleSoft flows
 */
@SpringBootTest
public class VibesControllerTest {

    @Autowired
    private VibesAnalysisService vibesAnalysisService;

    @Autowired
    private MusicRecommendationService musicRecommendationService;

    @Autowired
    private HealthService healthService;

    @Test
    public void testHealthService() {
        HealthResponse health = healthService.getHealthStatus();
        assertNotNull(health);
        assertEquals("healthy", health.getStatus());
        assertEquals("vibes-poc", health.getService());
        assertEquals("1.0.0", health.getVersion());
    }

    @Test
    public void testVibesAnalysisPositive() {
        VibesResponse response = vibesAnalysisService.analyzeVibes("I am so happy and excited about this amazing day!");
        
        assertNotNull(response);
        assertEquals("positive", response.getAnalysis().getSentiment());
        assertEquals("upbeat", response.getRecommendations().getMusicGenre());
        assertEquals("dancing", response.getRecommendations().getSuggestedActivity());
    }

    @Test
    public void testVibesAnalysisNegative() {
        VibesResponse response = vibesAnalysisService.analyzeVibes("I am feeling terrible and sad about this awful situation");
        
        assertNotNull(response);
        assertEquals("negative", response.getAnalysis().getSentiment());
        assertEquals("mellow", response.getRecommendations().getMusicGenre());
        assertEquals("relaxation", response.getRecommendations().getSuggestedActivity());
    }

    @Test
    public void testVibesAnalysisNeutral() {
        VibesResponse response = vibesAnalysisService.analyzeVibes("The weather is okay today");
        
        assertNotNull(response);
        assertEquals("neutral", response.getAnalysis().getSentiment());
        assertEquals("ambient", response.getRecommendations().getMusicGenre());
        assertEquals("meditation", response.getRecommendations().getSuggestedActivity());
    }

    @Test
    public void testVibesAnalysisWithEmptyText() {
        assertThrows(IllegalArgumentException.class, () -> {
            vibesAnalysisService.analyzeVibes("");
        });
    }

    @Test
    public void testMusicPlaylistsGet() {
        PlaylistsResponse response = musicRecommendationService.getPopularPlaylists();
        
        assertNotNull(response);
        assertNotNull(response.getPlaylists());
        assertEquals(3, response.getTotalPlaylists());
        assertEquals("Positive Vibes", response.getPlaylists().get(0).getName());
    }

    @Test
    public void testCustomPlaylistCreation() {
        CustomPlaylistRequest request = new CustomPlaylistRequest("positive", "pop");
        CustomPlaylistResponse response = musicRecommendationService.createCustomPlaylist(request);
        
        assertNotNull(response);
        assertEquals("positive", response.getCustomPlaylist().getMood());
        assertEquals("pop", response.getCustomPlaylist().getGenre());
        assertNotNull(response.getCustomPlaylist().getTracks());
        assertTrue(response.getCustomPlaylist().getTracks().size() > 0);
    }
}