package com.example.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orderservice.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // TODO: Add custom query methods if necessary for specific order retrieval patterns
    // For example:
    // List<Order> findByUserId(Long userId);
    List<Order> findByUserId(Long userId);
}