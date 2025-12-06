package com.example.transaction.runner;

import com.example.transaction.entity.Product;
import com.example.transaction.exception.InsufficientStockException;
import com.example.transaction.repository.AuditLogRepository;
import com.example.transaction.repository.OrderRepository;
import com.example.transaction.repository.ProductRepository;
import com.example.transaction.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class AppRunner implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final AuditLogRepository auditLogRepository;
    private final OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Initializing data...");
        productRepository.save(new Product(null, "Laptop", 1200.00, 5));
        productRepository.save(new Product(null, "Mouse", 25.00, 10));
        productRepository.save(new Product(null, "Keyboard", 75.00, 3));
        productRepository.save(new Product(null, "Monitor", 300.00, 2));

        log.info("Initial Products in DB:");
        productRepository.findAll().forEach(p -> log.info("  {}", p));

        log.info("\n--- Testing successful order placement ---");
        try {
            Map<Long, Integer> successfulOrder = new HashMap<>();
            successfulOrder.put(1L, 1); // Laptop
            successfulOrder.put(2L, 2); // Mouse
            orderService.placeOrder(successfulOrder);
            log.info("Successful order placed. Products and orders should be updated.");
        } catch (InsufficientStockException e) {
            log.error("Error placing successful order: {}", e.getMessage());
        } catch (Exception e) {
            log.error("Unexpected error during successful order: {}", e.getMessage(), e);
        }
        log.info("Products after successful order:");
        productRepository.findAll().forEach(p -> log.info("  {}", p));
        log.info("Orders after successful order:");
        orderRepository.findAll().forEach(o -> log.info("  {}", o));

        log.info("\n--- Testing order placement with insufficient stock (should roll back) ---");
        try {
            Map<Long, Integer> failedOrder = new HashMap<>();
            failedOrder.put(3L, 5); // Keyboard (only 3 in stock)
            failedOrder.put(2L, 1); // Mouse
            orderService.placeOrder(failedOrder);
            log.info("This should not be printed if rollback worked correctly.");
        } catch (InsufficientStockException e) {
            log.error("Caught expected InsufficientStockException: {}. Changes should be rolled back.", e.getMessage());
        } catch (Exception e) {
            log.error("Unexpected error during failed order: {}", e.getMessage(), e);
        }
        log.info("Products after failed order (should be same as before):");
        productRepository.findAll().forEach(p -> log.info("  {}", p));
        log.info("Orders after failed order (no new order should exist):");
        orderRepository.findAll().forEach(o -> log.info("  {}", o));

        log.info("\n--- Task 2: Testing independent logging with failed order ---");
        log.info("Initial AuditLogs: {}", auditLogRepository.count());
        try {
            Map<Long, Integer> orderWithIndependentLog = new HashMap<>();
            orderWithIndependentLog.put(4L, 10); // Monitor (only 2 in stock, this will fail placeOrder)
            orderWithIndependentLog.put(1L, 1); // Laptop
            orderService.processOrderRequest(orderWithIndependentLog);
            log.info("This should not be printed if inner placeOrder failed.");
        } catch (InsufficientStockException e) {
            log.error("Caught expected InsufficientStockException in processOrderRequest: {}. Order changes should be rolled back, but AuditLog should persist.", e.getMessage());
        } catch (Exception e) {
            log.error("Unexpected error during independent logging test: {}", e.getMessage(), e);
        }

        log.info("\nVerification after independent logging test:");
        log.info("Products (should be same as before this test, no changes):");
        productRepository.findAll().forEach(p -> log.info("  {}", p));
        log.info("Orders (no new order should exist from this test):");
        orderRepository.findAll().forEach(o -> log.info("  {}", o));
        log.info("AuditLogs (a new log entry should be present despite order failure):");
        auditLogRepository.findAll().forEach(al -> log.info("  {}", al));

        log.info("\n--- Application finished. You can access H2 console at http://localhost:8080/h2-console ---");
    }
}