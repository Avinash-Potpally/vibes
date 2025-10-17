package com.mulesoft.poc.vibes.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for the Vibes POC application
 * Demonstrates the same centralized error handling patterns used in MuleSoft
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> error = new HashMap<>();
        Map<String, String> fieldErrors = new HashMap<>();
        
        ex.getBindingResult().getAllErrors().forEach((errorObj) -> {
            String fieldName = ((FieldError) errorObj).getField();
            String errorMessage = errorObj.getDefaultMessage();
            fieldErrors.put(fieldName, errorMessage);
        });

        error.put("message", "Validation failed");
        error.put("type", "VALIDATION_ERROR");
        error.put("timestamp", LocalDateTime.now());
        error.put("service", "vibes-poc");
        error.put("fieldErrors", fieldErrors);

        Map<String, Object> response = new HashMap<>();
        response.put("error", error);
        response.put("supportInfo", "Please check your request format and try again");

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("message", ex.getMessage());
        error.put("type", "INVALID_ARGUMENT");
        error.put("timestamp", LocalDateTime.now());
        error.put("service", "vibes-poc");

        Map<String, Object> response = new HashMap<>();
        response.put("error", error);
        response.put("supportInfo", "Please check your request format and try again");

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("message", "An unexpected error occurred");
        error.put("type", "INTERNAL_ERROR");
        error.put("timestamp", LocalDateTime.now());
        error.put("service", "vibes-poc");
        error.put("details", ex.getMessage());

        Map<String, Object> response = new HashMap<>();
        response.put("error", error);
        response.put("supportInfo", "Please contact support if this error persists");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}