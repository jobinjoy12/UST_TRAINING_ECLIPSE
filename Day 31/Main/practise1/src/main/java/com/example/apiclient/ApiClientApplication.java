package com.example.apiclient;

import com.example.apiclient.service.ApiClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApiClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiClientApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner run(ApiClientService apiClientService) {
        return args -> {
            System.out.println("Starting API analysis...");
            apiClientService.performApiAnalysis();
            System.out.println("API analysis completed.");
        };
    }
}