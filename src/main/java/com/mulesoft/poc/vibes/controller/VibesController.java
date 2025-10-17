package com.mulesoft.poc.vibes.controller;

import com.mulesoft.poc.vibes.model.*;
import com.mulesoft.poc.vibes.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * REST Controller implementing the Vibes POC API endpoints
 * 
 * This controller demonstrates the same REST API patterns that would be
 * implemented in MuleSoft flows, including error handling and validation.
 */
@RestController
@RequestMapping("/api")
@Validated
public class VibesController {

    @Autowired
    private VibesAnalysisService vibesAnalysisService;
    
    @Autowired
    private MusicRecommendationService musicRecommendationService;
    
    @Autowired
    private HealthService healthService;

    /**
     * Health check endpoint for monitoring
     */
    @GetMapping("/health")
    public ResponseEntity<HealthResponse> getHealth() {
        HealthResponse health = healthService.getHealthStatus();
        return ResponseEntity.ok(health);
    }

    /**
     * Analyze text vibes and sentiment
     */
    @PostMapping("/vibes")
    public ResponseEntity<VibesResponse> analyzeVibes(@Valid @RequestBody VibesRequest request) {
        VibesResponse response = vibesAnalysisService.analyzeVibes(request.getText());
        return ResponseEntity.ok(response);
    }

    /**
     * Get popular music playlists
     */
    @GetMapping("/music")
    public ResponseEntity<PlaylistsResponse> getPlaylists() {
        PlaylistsResponse response = musicRecommendationService.getPopularPlaylists();
        return ResponseEntity.ok(response);
    }

    /**
     * Create custom music playlist based on mood and genre
     */
    @PostMapping("/music")
    public ResponseEntity<CustomPlaylistResponse> createCustomPlaylist(@Valid @RequestBody CustomPlaylistRequest request) {
        CustomPlaylistResponse response = musicRecommendationService.createCustomPlaylist(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Catch-all for undefined endpoints
     */
    @RequestMapping("/**")
    public ResponseEntity<Map<String, Object>> handleUndefinedEndpoints() {
        Map<String, Object> response = Map.of(
            "error", "Endpoint not found",
            "availableEndpoints", java.util.Arrays.asList("/api/health", "/api/vibes", "/api/music")
        );
        return ResponseEntity.status(404).body(response);
    }
}