package com.epam.healthcaremanagementapp.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MapService {

    @Value("${google.maps.api.key}")
    private String googleMapsApiKey;

    private final RestTemplate restTemplate;

    public MapService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> geocodeAddress(String address) {
        // Google Maps Geocoding API endpoint
        String apiUrl = "https://maps.googleapis.com/maps/api/geocode/json";

        // Build the request URL with the provided address and API key
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("address", address)
                .queryParam("key", googleMapsApiKey);

        // Make a GET request to the Google Maps Geocoding API
        return restTemplate.getForEntity(uriBuilder.toUriString(), String.class);
    }
}