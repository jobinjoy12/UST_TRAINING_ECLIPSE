package com.example.ecommerce.controller;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        // TODO: Implement POST /api/customers to register a new customer.
        // Return a 201 Created status with the registered customer.
        Customer cust = customerService.registerCustomer(customer);
        return new ResponseEntity<>(cust , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        // TODO: Implement GET /api/customers to retrieve all customers.
        // Return a 200 OK status with a list of customers.
        return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        // TODO: Implement GET /api/customers/{id} to retrieve a customer by ID.
        // Return 200 OK if found, 404 Not Found otherwise.
        return new ResponseEntity<>(customerService.getCustomerById(id).get(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        // TODO: Implement PUT /api/customers/{id} to update an existing customer.
        // Return 200 OK with the updated customer, or 404 Not Found if the customer does not exist.
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        // TODO: Implement DELETE /api/customers/{id} to delete a customer.
        // Return 204 No Content on success, or 404 Not Found if the customer does not exist.
        return null;
    }
}
