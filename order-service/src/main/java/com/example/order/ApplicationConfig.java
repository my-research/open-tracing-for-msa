package com.example.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import zipkin2.reporter.Sender;

@Configuration
public class ApplicationConfig {
    @Bean
    public RestTemplate rest() {
        Sender
        return new RestTemplate();
    }
}
