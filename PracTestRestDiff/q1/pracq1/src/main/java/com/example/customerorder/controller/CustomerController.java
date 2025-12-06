package com.example.customerorder.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.customerorder.dto.CustomerRequest;
import com.example.customerorder.dto.OrderRequest;
import com.example.customerorder.model.Customer;
import com.example.customerorder.model.Order;
import com.example.customerorder.repository.CustomerRepository;
import com.example.customerorder.repository.OrderRepository;



@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<Customer> createCust(@RequestBody CustomerRequest cr){
        Customer customer = new Customer(cr.getName(),cr.getEmail());

        Customer customerS = customerRepository.save(customer);

        return ResponseEntity.created(URI.create("/customers"+customerS.getId())).body(customerS);

    }


    @PostMapping("/{customerId}/orders")
    public ResponseEntity postMethodName(@PathVariable Long customerId , @RequestBody OrderRequest or) {
        //TODO: process POST request
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }   
        Order order = new Order(or.getTotalAmount());
        Order order1 = orderRepository.save(order);
        order.setCustomer(customer.get());
        return ResponseEntity.created(URI.create("/customers/{customerId}/orders"+order1.getId())).body(order1);
    }
    
  
    @GetMapping("/{customerId}/orders")
    public ResponseEntity<List> getMethodName(@PathVariable Long customerId ) {
        Optional<Customer> opt = customerRepository.findById(customerId);
        if(opt.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        List<Order> lOrder = orderRepository.findByCustomerId(customerId);
        return ResponseEntity.ok(lOrder);
    }
    


    @GetMapping("/orders/totalAmountGreaterThan")
    public ResponseEntity<List<Order>> getOrdersGreaterThanTotalAmount(@RequestParam double minAmount) {
     
        List<Order> lOrders = orderRepository.findOrdersByTotalAmountGreaterThan(minAmount);
        return ResponseEntity.ok(lOrders);
    }
}
