package com.mulesoft.poc.vibes.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Response model for music playlists
 */
public class PlaylistsResponse {
    
    private List<Playlist> playlists;
    private int totalPlaylists;
    private LocalDateTime timestamp;

    public PlaylistsResponse() {}

    public PlaylistsResponse(List<Playlist> playlists, int totalPlaylists, LocalDateTime timestamp) {
        this.playlists = playlists;
        this.totalPlaylists = totalPlaylists;
        this.timestamp = timestamp;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public int getTotalPlaylists() {
        return totalPlaylists;
    }

    public void setTotalPlaylists(int totalPlaylists) {
        this.totalPlaylists = totalPlaylists;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public static class Playlist {
        private String id;
        private String name;
        private String genre;
        private List<String> tracks;
        private String mood;
        private String duration;

        public Playlist() {}

        public Playlist(String id, String name, String genre, List<String> tracks, String mood, String duration) {
            this.id = id;
            this.name = name;
            this.genre = genre;
            this.tracks = tracks;
            this.mood = mood;
            this.duration = duration;
        }

        // Getters and setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public String getGenre() { return genre; }
        public void setGenre(String genre) { this.genre = genre; }
        
        public List<String> getTracks() { return tracks; }
        public void setTracks(List<String> tracks) { this.tracks = tracks; }
        
        public String getMood() { return mood; }
        public void setMood(String mood) { this.mood = mood; }
        
        public String getDuration() { return duration; }
        public void setDuration(String duration) { this.duration = duration; }
    }
}