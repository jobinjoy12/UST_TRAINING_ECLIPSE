package com.example.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // TODO: 1. Identify Core Responsibilities and design a conceptual REST API.
    //       Implement the conceptual API endpoints here based on the instructions.
    //       For example, you might have:
    //
    // Endpoint: POST /orders
    // Description: Creates a new order.
    // Request Body: { "userId": "...", "items": [...], "shippingAddress": "..." }
    // Response: { "orderId": "...", "status": "PENDING" }
    //
    // Example of a placeholder method:
    // @PostMapping
    // public ResponseEntity<Order> createOrder(@RequestBody Order order) {
    //     // Conceptual implementation, no actual logic needed for this task
    //     return ResponseEntity.ok(orderService.createOrder(order));
    // }
    //
    // Add more methods for GET /orders/{orderId}, PUT /orders/{orderId}/status, etc.
    // Consider what operations an Order Service should expose.

    // Placeholder for conceptual API methods:
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        // TODO: Implement logic for creating an order conceptually.
        // The actual task is about design, so this can be a placeholder.
        System.out.println("Conceptual API Call: POST /api/orders with order: " + order.getId());
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        // TODO: Implement logic for retrieving an order conceptually.
        System.out.println("Conceptual API Call: GET /api/orders/" + orderId);
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        // TODO: Implement logic for updating order status conceptually.
        System.out.println("Conceptual API Call: PUT /api/orders/" + orderId + "/status with status: " + status);
        return ResponseEntity.ok(orderService.updateOrderStatus(orderId, status));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        // TODO: Implement logic for retrieving all orders (or by user) conceptually.
        System.out.println("Conceptual API Call: GET /api/orders");
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // Add other relevant endpoints based on your core responsibilities identified in DESIGN_DOCUMENT.md
}
