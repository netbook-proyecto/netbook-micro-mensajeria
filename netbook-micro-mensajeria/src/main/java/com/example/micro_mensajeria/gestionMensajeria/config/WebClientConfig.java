package com.example.micro_mensajeria.gestionMensajeria.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${app.auth.base-url}")
    private String authBaseUrl;

    @Bean
    public WebClient authWebClient() {
        return WebClient.builder().baseUrl(authBaseUrl).build();
    }
}