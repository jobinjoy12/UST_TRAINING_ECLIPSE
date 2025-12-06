package com.example.com.ust;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
        public static void main(String[] args) {
            // Load the Spring configuration file
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

            // Retrieve the bean by its ID
            GreetingService service = (GreetingService) context.getBean("myGreetingService");

            // Use the retrieved bean
            service.displayGreeting();

            // Close the context (optional, but good practice for desktop apps)
            ((ClassPathXmlApplicationContext) context).close();
        }
    }