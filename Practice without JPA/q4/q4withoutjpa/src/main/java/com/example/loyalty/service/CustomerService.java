package com.example.loyalty.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.loyalty.exception.CustomerNotFoundException;
import com.example.loyalty.exception.DuplicateCustomerException;
import com.example.loyalty.model.Customer;
import com.example.loyalty.model.CustomerPatchDto;
import com.example.loyalty.model.CustomerRegistrationDto;
import com.example.loyalty.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        // TODO: Implement method to retrieve all customers.
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        // TODO: Implement method to fetch a single customer by their ID.
        // Throw CustomerNotFoundException if customer is not found.
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + id + " not found."));
    }

    public Customer registerNewCustomer(CustomerRegistrationDto customerDto) {
        // TODO: Implement logic to register a new customer.
        // 1. Validate for duplicate email address. If found, throw DuplicateCustomerException.
        // 2. Assign a new unique customer ID (already handled by repository's save method).
        // 3. Set registrationDate if not provided in DTO (e.g., LocalDate.now().toString()).
        // 4. Set initial loyaltyPoints if not provided in DTO (e.g., 0).
        // 5. Save the new customer.

        if (customerRepository.findByEmail(customerDto.getEmail()).isPresent()) {
            throw new DuplicateCustomerException("Customer with email " + customerDto.getEmail() + " already exists.");
        }

        Customer newCustomer = new Customer();
        newCustomer.setFirstName(customerDto.getFirstName());
        newCustomer.setLastName(customerDto.getLastName());
        newCustomer.setEmail(customerDto.getEmail());
        newCustomer.setLoyaltyPoints(customerDto.getLoyaltyPoints() > 0 ? customerDto.getLoyaltyPoints() : 0);
        newCustomer.setRegistrationDate(customerDto.getRegistrationDate() != null && !customerDto.getRegistrationDate().isEmpty() 
                                          ? customerDto.getRegistrationDate() : LocalDate.now().toString());

        return customerRepository.save(newCustomer);
    }

    public Customer updateCustomer(int id, Customer updatedCustomer) {
        // TODO: Implement logic to update an existing customer's profile.
        // Throw CustomerNotFoundException if the customer with the given ID does not exist.
        // Ensure the ID in the path matches the ID of the updated customer object.

        customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + id + " not found for update."));
        
        updatedCustomer.setId(id);
        customerRepository.update(updatedCustomer);
        return updatedCustomer; // Or fetch again from repo to ensure consistency
    }

    public void deleteCustomer(int id) {
        // TODO: Implement logic to remove a customer profile by ID.
        // Throw CustomerNotFoundException if customer is not found.
        if (customerRepository.findById(id).isEmpty()) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found for deletion.");
        }
        customerRepository.deleteById(id);
    }

    public List<Customer> findCustomersByLastName(String lastName) {
        // TODO: Implement method to search for customers by their lastName.
        // Return an empty list if no customers are found.
        return customerRepository.findAll().stream()
                .filter(c -> c.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    public List<Customer> sortCustomersByLoyaltyPoints() {
        // TODO: Implement method to return customers sorted by their loyaltyPoints in descending order.
        return customerRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Customer::getLoyaltyPoints).reversed())
                .collect(Collectors.toList());
    }

    public Customer patchCustomer(int id, CustomerPatchDto patchDto) {
        // TODO: Implement logic for flexible profile updates (PATCH).
        // Allow updating only email or loyaltyPoints fields. Other attributes should remain unchanged.
        // Throw CustomerNotFoundException if customer is not found.
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + id + " not found for patch."));

        if (patchDto.getEmail() != null && !patchDto.getEmail().isEmpty()) {
            // TODO: Add validation for duplicate email during patch if the email is changed
            existingCustomer.setEmail(patchDto.getEmail());
        }
        if (patchDto.getLoyaltyPoints() != null) {
            existingCustomer.setLoyaltyPoints(patchDto.getLoyaltyPoints());
        }
        customerRepository.update(existingCustomer);
        return existingCustomer;
    }

    public int getTotalRegisteredCustomers() {
        // TODO: Implement method to report the total number of customers.
        return customerRepository.count();
    }

    public void clearAllCustomers() {
        // TODO: Implement method to remove all customer profiles from the in-memory store.
        customerRepository.clearAll();
    }
}
