package com.example.orderservice.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // This is a conceptual implementation for the design task.
    // In a real application, you would use the repository to interact with the database.
    private final AtomicLong orderIdCounter = new AtomicLong(); // For simulating ID generation conceptually
    private final List<Order> conceptualOrders = new ArrayList<>(); // For simulating persistence conceptually

    public Order createOrder(Order order) {
        // TODO: Implement the actual order creation logic, interacting with OrderRepository.
        // For this design task, we'll simulate it conceptually.
        if (order.getId() == null) {
            order.setId(orderIdCounter.incrementAndGet());
        }
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");

        // Simulate saving to DB
        // orderRepository.save(order);
        conceptualOrders.add(order);
        System.out.println("Conceptual: Created order " + order.getId() + " for user " + order.getUserId());
        return order;
    }

    public Order getOrderById(Long orderId) {
        // TODO: Implement actual retrieval logic from OrderRepository.
        // For this design task, we'll simulate it conceptually.
        // return orderRepository.findById(orderId).orElse(null);
        return conceptualOrders.stream().filter(o -> o.getId().equals(orderId)).findFirst().orElse(null);
    }

    public Order updateOrderStatus(Long orderId, String newStatus) {
        // TODO: Implement actual update logic using OrderRepository.
        // For this design task, we'll simulate it conceptually.
        Optional<Order> optionalOrder = conceptualOrders.stream().filter(o -> o.getId().equals(orderId)).findFirst();
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus(newStatus);
            // orderRepository.save(order);
            System.out.println("Conceptual: Updated order " + orderId + " status to " + newStatus);
            return order;
        }
        return null; // Or throw an exception
    }

    public List<Order> getAllOrders() {
        // TODO: Implement actual retrieval logic from OrderRepository.
        // For this design task, we'll simulate it conceptually.
        // return orderRepository.findAll();
        return new ArrayList<>(conceptualOrders);
    }

    // TODO: Add other service methods corresponding to the identified core responsibilities.
    // e.g., getOrdersByUserId(Long userId), cancelOrder(Long orderId), etc.
    public List<Order> getOrdersByUserId(Long userId)
    {
        List<Order> list = conceptualOrders.stream().filter(o->o.getUserId().equals(userId)).toList();
        return list ;
    }

    public Order cancelOrder(Long orderId)
    {
       Optional<Order> opt =  conceptualOrders.stream().filter(o->o.getId().equals(orderId)).findFirst();

       if(opt.isPresent())
       {
        Order ord =  opt.get();
        ord.setStatus("CANCELLED");
        return ord;
       }
       return null;
    }
}
