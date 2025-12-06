package com.example.transaction.service;

import com.example.transaction.entity.Order;
import com.example.transaction.entity.Product;
import com.example.transaction.exception.InsufficientStockException;
import com.example.transaction.repository.OrderRepository;
import com.example.transaction.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final AuditLogService auditLogService;

    @Transactional
    public Order placeOrder(Map<Long, Integer> productQuantities) {
     
        double totalAmount = 0.0;
        Order newOrder = new Order();
        newOrder.setOrderDate(LocalDateTime.now());
        newOrder.setStatus("PENDING");

        for (Map.Entry<Long, Integer> entry : productQuantities.entrySet()) {
            Long productId = entry.getKey();
            Integer quantity = entry.getValue();

            Optional<Product> productOpt = productRepository.findById(productId);
            if (productOpt.isEmpty()) {
                throw new IllegalArgumentException("Product with ID " + productId + " not found.");
            }
            Product product = productOpt.get();

            if (product.getStock() < quantity) {
                throw new InsufficientStockException("Insufficient stock for product: " + product.getName() + ". Available: " + product.getStock() + ", Requested: " + quantity);
            }

            product.setStock(product.getStock() - quantity);
            productRepository.save(product);

            totalAmount += product.getPrice() * quantity;

        }

        newOrder.setTotalAmount(totalAmount);
        return orderRepository.save(newOrder);
    }

    @Transactional
    public Order processOrderRequest(Map<Long, Integer> productQuantities) {
        auditLogService.logAction("Attempting to place order for customer with products: " + productQuantities.keySet());
        return placeOrder(productQuantities);
    }
}