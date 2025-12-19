package com.example.loyalty.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.example.loyalty.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Repository
public class CustomerRepository {

    private final List<Customer> customers = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String DATA_FILE = "customers.json";

    public CustomerRepository() {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @PostConstruct
    public void loadData() {
        // TODO: Implement logic to load customer data from customers.json at application startup.
        // If the file does not exist or is empty, initialize customers list as empty.
        // Remember to update idCounter based on the loaded customers to ensure unique IDs for new registrations.
        File file = Paths.get(DATA_FILE).toFile();
        if (file.exists() && file.length() > 0) {
            try {
                Customer[] loadedCustomers = objectMapper.readValue(file, Customer[].class);
                customers.addAll(Arrays.asList(loadedCustomers));
                customers.stream().mapToInt(Customer::getId).max().ifPresent(idCounter::set);
                System.out.println("Loaded " + customers.size() + " customers from " + DATA_FILE);
            } catch (IOException e) {
                System.err.println("Error loading customers from file: " + e.getMessage());
            }
        }
    }

    @PreDestroy
    public void saveData() {
        // TODO: Implement logic to save the current customer list to customers.json upon application shutdown.
        // Ensure proper error handling for file operations.
        try {
            objectMapper.writeValue(Paths.get(DATA_FILE).toFile(), customers);
            System.out.println("Saved " + customers.size() + " customers to " + DATA_FILE);
        } catch (IOException e) {
            System.err.println("Error saving customers to file: " + e.getMessage());
        }
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }

    public Optional<Customer> findById(int id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    public Optional<Customer> findByEmail(String email) {
        return customers.stream()
                .filter(c -> c.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public Customer save(Customer customer) {
        if (customer.getId() == 0) {
            customer.setId(idCounter.incrementAndGet());
        }
        customers.add(customer);
        return customer;
    }

    public void update(Customer updatedCustomer) {
        customers.stream()
                .filter(c -> c.getId() == updatedCustomer.getId())
                .findFirst()
                .ifPresent(c -> {
                    c.setFirstName(updatedCustomer.getFirstName());
                    c.setLastName(updatedCustomer.getLastName());
                    c.setEmail(updatedCustomer.getEmail());
                    c.setLoyaltyPoints(updatedCustomer.getLoyaltyPoints());
                    c.setRegistrationDate(updatedCustomer.getRegistrationDate());
                });
    }

    public void deleteById(int id) {
        customers.removeIf(c -> c.getId() == id);
    }

    public int count() {
        return customers.size();
    }

    public void clearAll() {
        customers.clear();
        idCounter.set(0);
    }

    public List<Customer> getCustomersInternal() {
        return customers; // Only for direct manipulation if necessary, use sparingly.
    }
}
