package com.mulesoft.poc.vibes.service;

import com.mulesoft.poc.vibes.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Service for music recommendations
 * Demonstrates the same business logic patterns used in MuleSoft flows
 */
@Service
public class MusicRecommendationService {

    public PlaylistsResponse getPopularPlaylists() {
        List<PlaylistsResponse.Playlist> playlists = Arrays.asList(
            new PlaylistsResponse.Playlist(
                "1",
                "Positive Vibes",
                "upbeat",
                Arrays.asList(
                    "Happy - Pharrell Williams",
                    "Can't Stop the Feeling - Justin Timberlake",
                    "Good as Hell - Lizzo"
                ),
                "positive",
                "45 minutes"
            ),
            new PlaylistsResponse.Playlist(
                "2",
                "Chill Vibes",
                "mellow",
                Arrays.asList(
                    "Weightless - Marconi Union",
                    "Clair de Lune - Debussy",
                    "Mad World - Gary Jules"
                ),
                "neutral",
                "38 minutes"
            ),
            new PlaylistsResponse.Playlist(
                "3",
                "Energy Boost",
                "energetic",
                Arrays.asList(
                    "Thunder - Imagine Dragons",
                    "Uptown Funk - Mark Ronson ft. Bruno Mars",
                    "I Gotta Feeling - Black Eyed Peas"
                ),
                "positive",
                "42 minutes"
            )
        );

        return new PlaylistsResponse(playlists, playlists.size(), LocalDateTime.now());
    }

    public CustomPlaylistResponse createCustomPlaylist(CustomPlaylistRequest request) {
        String mood = request.getMood();
        String genre = request.getGenre() != null ? request.getGenre() : "mixed";

        List<String> tracks = generateTracksForMood(mood);
        
        CustomPlaylistResponse.PlaylistRecommendations recommendations = 
            new CustomPlaylistResponse.PlaylistRecommendations(
                Arrays.asList("More " + mood + " vibes", "Curated " + genre + " selection"),
                getNextSuggestion(mood)
            );

        CustomPlaylistResponse.CustomPlaylist customPlaylist = 
            new CustomPlaylistResponse.CustomPlaylist(
                mood,
                genre,
                LocalDateTime.now(),
                tracks,
                "35 minutes",
                recommendations
            );

        return new CustomPlaylistResponse(customPlaylist);
    }

    private List<String> generateTracksForMood(String mood) {
        switch (mood.toLowerCase()) {
            case "positive":
                return Arrays.asList(
                    "Good Vibes - Dua Lipa",
                    "Sunshine - Matisyahu",
                    "Walking on Sunshine - Katrina and the Waves"
                );
            case "negative":
                return Arrays.asList(
                    "Hurt - Johnny Cash",
                    "Black - Pearl Jam",
                    "Mad World - Tears for Fears"
                );
            default:
                return Arrays.asList(
                    "Breathe Me - Sia",
                    "The Sound of Silence - Simon & Garfunkel",
                    "Hallelujah - Jeff Buckley"
                );
        }
    }

    private String getNextSuggestion(String mood) {
        switch (mood.toLowerCase()) {
            case "positive":
                return "energetic";
            case "negative":
                return "uplifting";
            default:
                return "relaxing";
        }
    }
}