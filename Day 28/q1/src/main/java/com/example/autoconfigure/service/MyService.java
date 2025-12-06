package com.example.autoconfigure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyService {

    @Autowired
    public RestTemplate restTemplate;

    // TODO: 1. Autowire the 'RestTemplate' bean here.
    //       Spring Boot auto-configures a RestTemplate bean when 'spring-boot-starter-web' is on the classpath.
    //       You can observe this by checking the application context for 'restTemplate' or similar beans.
    //       Example: @Autowired private RestTemplate restTemplate;


    public void performAction() {
        System.out.println("\n--- MyService is performing an action ---");

        System.out.println("RestTemplate bean autowired succesfully");
        System.out.println("RestTemplate instance: " + restTemplate.getClass().getName());
        String result = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", String.class); 
        // TODO: 2. After autowiring, demonstrate its usage.
        //       For example, you can print a message confirming its presence or try to make a dummy call.
        //       If 'RestTemplate' is autowired, you can print a message like:
        //       System.out.println("RestTemplate bean autowired successfully!");
        //       System.out.println("RestTemplate instance: " + restTemplate.getClass().getName());
        //       (Optional) You can try to fetch data from a public API, e.g., String result = restTemplate.getForObject("https://www.example.com", String.class);

        System.out.println("--- Action complete ---");
    }
}


//Got the expected output 