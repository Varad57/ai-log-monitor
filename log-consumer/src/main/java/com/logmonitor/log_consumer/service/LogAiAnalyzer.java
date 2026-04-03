package com.logmonitor.log_consumer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class LogAiAnalyzer {

    private final RestTemplate restTemplate = new RestTemplate();

    // This pulls the base URL from Docker and appends the specific API endpoint
    @Value("${OLLAMA_API_URL:http://localhost:11434}")
    private String ollamaBaseUrl;

    public String analyze(String logMessage) {
        // Construct the full URL
        String fullUrl = ollamaBaseUrl + "/api/generate";

        Map<String, Object> body = new HashMap<>();
        body.put("model", "tinyllama");
        body.put("stream", false);
        body.put("prompt", "Analyze this error log and give: 1) Severity 2) Root Cause 3) Fix. Keep it short.\n\nError: " + logMessage);

        try {
            Map response = restTemplate.postForObject(fullUrl, body, Map.class);
            return response != null ? response.get("response").toString() : "AI analysis empty";
        } catch (Exception e) {
            return "AI Error: " + e.getMessage();
        }
    }
}