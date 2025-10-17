# MuleSoft Vibes POC - Quick Start Guide

## Running the Application

### Prerequisites
- Java 8 or higher
- Maven 3.6+

### Start the Application
```bash
# Build and run the application
mvn clean package
java -jar target/vibes-poc-1.0.0-SNAPSHOT.jar

# Alternative: Run with Maven (for development)
mvn spring-boot:run
```

The application will start on port 8081.

## Testing the API

### 1. Health Check
```bash
curl -X GET http://localhost:8081/api/health
```

**Expected Response:**
```json
{
  "status": "healthy",
  "service": "vibes-poc",
  "timestamp": "2025-10-17T05:33:50.188662035",
  "version": "1.0.0"
}
```

### 2. Vibes Analysis

#### Positive Sentiment
```bash
curl -X POST http://localhost:8081/api/vibes \
  -H "Content-Type: application/json" \
  -d '{"text": "I am feeling absolutely amazing and excited about this wonderful day!"}'
```

**Expected Response:**
```json
{
  "analysis": {
    "text": "I am feeling absolutely amazing and excited about this wonderful day!",
    "sentiment": "positive",
    "vibeIntensity": "medium",
    "wordCount": 11,
    "characterCount": 69,
    "timestamp": "2025-10-17T05:35:18.90215139",
    "confidence": "high"
  },
  "recommendations": {
    "musicGenre": "upbeat",
    "mood": "positive",
    "suggestedActivity": "dancing"
  }
}
```

#### Negative Sentiment
```bash
curl -X POST http://localhost:8081/api/vibes \
  -H "Content-Type: application/json" \
  -d '{"text": "I am feeling terrible and sad and awful about this horrible situation"}'
```

#### Validation Error
```bash
curl -X POST http://localhost:8081/api/vibes \
  -H "Content-Type: application/json" \
  -d '{"text": ""}'
```

### 3. Music Recommendations

#### Get Popular Playlists
```bash
curl -X GET http://localhost:8081/api/music
```

#### Create Custom Playlist
```bash
curl -X POST http://localhost:8081/api/music \
  -H "Content-Type: application/json" \
  -d '{"mood": "positive", "genre": "pop"}'
```

### 4. Error Testing

#### Undefined Endpoint
```bash
curl -X GET http://localhost:8081/api/undefined
```

## Key Features Demonstrated

### MuleSoft Integration Patterns
- **REST API Gateway**: All endpoints follow RESTful patterns
- **Data Transformation**: Complex sentiment analysis with business logic
- **Error Handling**: Centralized error processing with proper HTTP status codes
- **Validation**: Input validation with meaningful error messages
- **Logging**: Structured logging throughout the application
- **Health Monitoring**: Standard health check endpoint for monitoring

### Business Logic
- **Sentiment Analysis**: Analyzes text for positive, negative, or neutral sentiment
- **Vibe Intensity**: Measures emotional intensity based on text characteristics
- **Music Recommendations**: Generates playlists based on detected mood
- **Confidence Scoring**: Provides confidence levels based on text length

### Technical Implementation
- **Spring Boot**: Modern Java framework demonstrating integration patterns
- **Maven**: Standard build and dependency management
- **JSON**: REST API with JSON request/response format
- **Unit Testing**: Comprehensive test coverage
- **Documentation**: OpenAPI specification and comprehensive README

## Integration Possibilities

This POC can be extended to integrate with:

1. **External APIs**: Spotify, Apple Music, social media platforms
2. **Databases**: User preferences, analytics, historical data
3. **Message Queues**: Real-time processing, event-driven architecture
4. **Security**: OAuth 2.0, JWT tokens, API rate limiting
5. **Analytics**: Data warehousing, machine learning models
6. **Monitoring**: APM tools, logging aggregation, metrics collection

## Files Overview

- `src/main/java/` - Application source code
- `src/test/java/` - Unit tests
- `src/main/mule/` - Original MuleSoft XML configuration (reference)
- `api-spec.yaml` - OpenAPI 3.0 specification
- `deployment.properties` - CloudHub deployment configuration
- `README.md` - Comprehensive documentation

## Stopping the Application

Press `Ctrl+C` in the terminal where the application is running, or:

```bash
# Find the process ID
ps aux | grep vibes-poc

# Kill the process
kill <PID>
```