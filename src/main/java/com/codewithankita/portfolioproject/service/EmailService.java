package com.codewithankita.portfolioproject.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

@Service
public class EmailService {

    @Value("${brevo.api.key}")
    private String apiKey;

    @Value("${app.mail.to}")
    private String toEmail;

    public void sendContactEmail(String name, String senderEmail, String message) {
        try {
            String jsonBody = String.format("""
                {
                    "sender": {"name": "Ankita Portfolio", "email": "kumariankitajapan@gmail.com"},
                    "to": [{"email": "%s"}],
                    "subject": "Portfolio Contact: %s",
                    "textContent": "Name: %s\\nEmail: %s\\n\\nMessage: %s"
                }
                """, toEmail, name, name, senderEmail, message);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.brevo.com/v3/smtp/email"))
                    .header("api-key", apiKey)
                    .header("content-type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            throw new RuntimeException("Failed to send email: " + e.getMessage());
        }
    }
}