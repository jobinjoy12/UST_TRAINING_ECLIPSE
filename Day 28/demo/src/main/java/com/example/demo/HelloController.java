package com.example.demo;

 import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class HelloController {
        @GetMapping("/helloJob")
        public String hello() {
            return "Hello, Spring Boot!";
        }
    }
