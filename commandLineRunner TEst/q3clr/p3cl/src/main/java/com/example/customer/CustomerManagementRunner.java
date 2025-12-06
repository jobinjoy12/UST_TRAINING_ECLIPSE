package com.example.customer;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;

@Component
public class CustomerManagementRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CustomerManagementRunner.class);
    private final CustomerRepository customerRepository;

    public CustomerManagementRunner(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Starting Customer Management Operations...");

        Customer c1 = new Customer("Niranj", "Alice", "alice.com", "1230");
        Customer c2 = new Customer("Sarat", "Bob", "bob.com", "8210");
        Customer c3 = new Customer("Sanjal", "jobin", "Jobin@ecom", "5555");

        customerRepository.saveAll(List.of(c1, c2, c3));
        log.info("Added customers: Alice, Bob, Charlie");

        List<Customer> customers = customerRepository.findAll();
        log.info("All customers in DB:");
        customers.forEach(c -> log.info(c.toString()));

        Long searchId = customers.get(0).getId();
        Optional<Customer> foundCustomer = customerRepository.findById(searchId);
        foundCustomer.ifPresentOrElse(
            c -> log.info("Found customer with ID {}: {}", searchId, c),
            () -> log.warn("Customer with ID {} not found", searchId)
        );

        if (foundCustomer.isPresent()) {
            Customer toUpdate = foundCustomer.get();
            toUpdate.setPhone("1112223333");
            customerRepository.save(toUpdate);
            log.info("Updated customer {} phone number to {}", toUpdate.getFirstName(), toUpdate.getPhone());
        }

        Long deleteId = customers.get(1).getId(); 
        customerRepository.deleteById(deleteId);
        log.info("Deleted customer with id", deleteId);

        List<Customer> remaining = customerRepository.findAll();
        log.info("Remaining customers after deletion:");
        remaining.forEach(c -> log.info(c.toString()));

        log.info("Customer Management Operations Finished.");
    }
}