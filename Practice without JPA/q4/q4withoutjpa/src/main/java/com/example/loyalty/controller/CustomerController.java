package com.example.loyalty.controller;

import com.example.loyalty.exception.CustomerNotFoundException;
import com.example.loyalty.exception.DuplicateCustomerException;
import com.example.loyalty.model.Customer;
import com.example.loyalty.model.CustomerPatchDto;
import com.example.loyalty.model.CustomerRegistrationDto;
import com.example.loyalty.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        // TODO: Implement GET /customers endpoint.
        // Retrieve and return a list of all registered customers.
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        // TODO: Implement GET /customers/{id} endpoint.
        // Fetch and return a single customer's profile by their unique ID.
        // Handle CustomerNotFoundException (via @ControllerAdvice).
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> registerNewCustomer(@RequestBody CustomerRegistrationDto customerDto) {
        // TODO: Implement POST /customers endpoint.
        // Register a new customer. Automatically assign a customer ID and handle registration date.
        // Handle DuplicateCustomerException (via @ControllerAdvice).
        Customer newCustomer = customerService.registerNewCustomer(customerDto);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        // TODO: Implement PUT /customers/{id} endpoint.
        // Update all editable details of an existing customer's profile.
        // Handle CustomerNotFoundException.
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        // TODO: Implement DELETE /customers/{id} endpoint.
        // Remove a customer profile by ID.
        // Handle CustomerNotFoundException.
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/find")
    public ResponseEntity<List<Customer>> findCustomersByLastName(@RequestParam String lastName) {
        // TODO: Implement GET /customers/find?lastName=Smith endpoint.
        // Search for customers by their lastName.
        List<Customer> customers = customerService.findCustomersByLastName(lastName);
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/sortByLoyalty")
    public ResponseEntity<List<Customer>> getCustomersSortedByLoyalty() {
        // TODO: Implement GET /customers/sortByLoyalty endpoint.
        // Return customers sorted by their loyaltyPoints in descending order.
        List<Customer> customers = customerService.sortCustomersByLoyaltyPoints();
        return ResponseEntity.ok(customers);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Customer> patchCustomer(@PathVariable int id, @RequestBody CustomerPatchDto patchDto) {
        // TODO: Implement PATCH /customers/{id} endpoint.
        // Allow updating only the email or loyaltyPoints fields without affecting other attributes.
        // Handle CustomerNotFoundException.
        Customer updatedCustomer = customerService.patchCustomer(id, patchDto);
        return ResponseEntity.ok(updatedCustomer);
    }

    @GetMapping("/totalRegistered")
    public ResponseEntity<Map<String, Integer>> getTotalRegisteredCustomers() {
        // TODO: Implement GET /customers/totalRegistered endpoint.
        // Report the total number of customers in the program in JSON format {"totalCustomers": 10}.
        int total = customerService.getTotalRegisteredCustomers();
        return ResponseEntity.ok(Map.of("totalCustomers", total));
    }

    @DeleteMapping("/clearAll")
    public ResponseEntity<Void> clearAllCustomers() {
        // TODO: Implement DELETE /customers/clearAll endpoint.
        // Remove all customer profiles from the in-memory store.
        customerService.clearAllCustomers();
        return ResponseEntity.noContent().build();
    }
}
