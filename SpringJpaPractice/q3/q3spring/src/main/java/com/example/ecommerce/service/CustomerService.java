package com.example.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Register new customer
    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Update customer details (excluding orders for safety)
    public Customer updateCustomer(Long id, Customer customerDetails) {
        return customerRepository.findById(id)
                .map(cust -> {
                    cust.setName(customerDetails.getName());
                    cust.setEmail(customerDetails.getEmail());
                    return customerRepository.save(cust);
                })
                .orElseThrow(() -> new RuntimeException("Customer with ID " + id + " not found"));
    }

    // Delete customer
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer with ID " + id + " not found");
        }
        customerRepository.deleteById(id);
    }

    // Add an order to a customer using helper method
    public Customer addOrderToCustomer(Long customerId, Order order) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer with ID " + customerId + " not found"));
        customer.addOrdre(order); // helper method keeps both sides in sync
        return customerRepository.save(customer);
    }

    // Remove an order from a customer using helper method
    public Customer removeOrderFromCustomer(Long customerId, Order order) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer with ID " + customerId + " not found"));
        customer.removeOrder(order); // helper method keeps both sides in sync
        return customerRepository.save(customer);
    }
}