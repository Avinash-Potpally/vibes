# MuleSoft Vibes POC

A proof of concept MuleSoft application demonstrating integration capabilities with sentiment analysis and music recommendation features.

## Overview

The Vibes POC showcases MuleSoft's capabilities through a RESTful API that:
- Analyzes text sentiment and vibes
- Provides music recommendations based on mood
- Demonstrates proper error handling and logging
- Includes comprehensive testing

## Features

### 🎵 Vibes Analysis
- Text sentiment analysis (positive, negative, neutral)
- Vibe intensity measurement (high, medium, low)
- Confidence scoring based on text length
- Music genre recommendations based on sentiment

### 🎶 Music Recommendations  
- GET endpoint for popular playlists
- POST endpoint for custom playlist generation
- Mood-based track suggestions
- Dynamic playlist creation based on user input

### 🏥 Health Monitoring
- Health check endpoint for system monitoring
- Service status and version information
- Timestamp tracking for monitoring tools

### 🛡️ Error Handling
- Comprehensive error handling across all flows
- Structured error responses with timestamps
- Input validation for all endpoints
- Proper HTTP status codes

## API Endpoints

### Health Check
```
GET /api/health
```
Returns system health status and service information.

**Response:**
```json
{
  "status": "healthy",
  "service": "vibes-poc", 
  "timestamp": "2023-10-17T05:19:37.062Z",
  "version": "1.0.0"
}
```

### Vibes Analysis
```
POST /api/vibes
Content-Type: application/json

{
  "text": "I am feeling amazing today!"
}
```

**Response:**
```json
{
  "analysis": {
    "text": "I am feeling amazing today!",
    "sentiment": "positive",
    "vibeIntensity": "medium",
    "wordCount": 5,
    "characterCount": 26,
    "timestamp": "2023-10-17T05:19:37.062Z",
    "confidence": "low"
  },
  "recommendations": {
    "musicGenre": "upbeat",
    "mood": "positive", 
    "suggestedActivity": "dancing"
  }
}
```

### Music Recommendations

#### Get Popular Playlists
```
GET /api/music
```

**Response:**
```json
{
  "playlists": [
    {
      "id": "1",
      "name": "Positive Vibes",
      "genre": "upbeat",
      "tracks": ["Happy - Pharrell Williams", "..."],
      "mood": "positive",
      "duration": "45 minutes"
    }
  ],
  "totalPlaylists": 3,
  "timestamp": "2023-10-17T05:19:37.062Z"
}
```

#### Create Custom Playlist
```
POST /api/music
Content-Type: application/json

{
  "mood": "positive",
  "genre": "pop"
}
```

**Response:**
```json
{
  "customPlaylist": {
    "mood": "positive",
    "genre": "pop",
    "generatedAt": "2023-10-17T05:19:37.062Z",
    "tracks": ["Good Vibes - Dua Lipa", "..."],
    "estimatedDuration": "35 minutes",
    "recommendations": {
      "similar": ["More positive vibes", "Curated pop selection"],
      "nextSuggestion": "energetic"
    }
  }
}
```

## Technical Architecture

### Technologies Used
- **MuleSoft Runtime:** 4.4.0
- **Build Tool:** Maven 3.8.2
- **Connectors:** HTTP, Validation
- **Data Transformation:** DataWeave 2.0
- **Testing:** MUnit
- **Logging:** Log4j2

### Project Structure
```
├── pom.xml                           # Maven configuration
├── src/
│   ├── main/
│   │   ├── mule/
│   │   │   └── vibes-poc.xml        # Main Mule configuration
│   │   └── resources/
│   │       ├── mule-app.properties  # Application properties
│   │       └── log4j2.xml          # Logging configuration
│   └── test/
│       └── munit/
│           └── vibes-poc-test.xml   # Unit tests
└── README.md                        # This file
```

### Flow Architecture
1. **Main API Flow:** Routes requests to appropriate sub-flows
2. **Health Check Flow:** System monitoring and status
3. **Vibes Analysis Flow:** Text processing and sentiment analysis
4. **Music Recommendation Flow:** Playlist generation and recommendations
5. **Error Handler Flow:** Centralized error processing

## Configuration

### Application Properties
The application uses the following configurable properties:

- `http.port`: HTTP listener port (default: 8081)
- `http.host`: HTTP listener host (default: 0.0.0.0)
- `app.name`: Application name
- `log.level`: Logging level

### Environment-Specific Configuration
Properties can be overridden for different environments:
- Development: Use default values in `mule-app.properties`
- Testing: Override properties via system properties
- Production: Use secure property placeholders

## Running the Application

### Prerequisites
- Java 8 or higher
- Maven 3.6+
- MuleSoft Runtime 4.4.0

### Local Development
1. Clone the repository
2. Navigate to the project directory
3. Run with Maven:
```bash
mvn clean compile mule:run
```

### Testing
Run the MUnit tests:
```bash
mvn test
```

### Deployment
Package the application:
```bash
mvn clean package
```

The resulting `.jar` file can be deployed to:
- Anypoint Studio
- CloudHub
- On-premises Mule Runtime

## API Testing Examples

### Using curl

Health Check:
```bash
curl -X GET http://localhost:8081/api/health
```

Vibes Analysis:
```bash
curl -X POST http://localhost:8081/api/vibes \
  -H "Content-Type: application/json" \
  -d '{"text": "This is an amazing day filled with joy and happiness!"}'
```

Music Recommendations:
```bash
curl -X GET http://localhost:8081/api/music

curl -X POST http://localhost:8081/api/music \
  -H "Content-Type: application/json" \
  -d '{"mood": "positive", "genre": "electronic"}'
```

## Future Enhancements

### Planned Features
- [ ] Integration with external sentiment analysis APIs
- [ ] Database persistence for analytics
- [ ] User authentication and authorization
- [ ] Rate limiting and throttling
- [ ] Caching for improved performance
- [ ] Integration with music streaming APIs (Spotify, Apple Music)
- [ ] Real-time analytics dashboard
- [ ] Machine learning model integration

### Possible Integrations
- **External APIs:** Spotify API, Twitter API, News APIs
- **Databases:** PostgreSQL, MongoDB, Redis
- **Message Queues:** RabbitMQ, Apache Kafka
- **Security:** OAuth 2.0, JWT tokens
- **Monitoring:** Datadog, New Relic, Splunk

## Contributing

1. Fork the repository
2. Create a feature branch
3. Add tests for new functionality
4. Run existing tests to ensure no regressions
5. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For questions and support:
- Create an issue in the repository
- Contact the development team
- Check MuleSoft documentation for runtime-specific questions

---

**Built with ❤️ using MuleSoft**