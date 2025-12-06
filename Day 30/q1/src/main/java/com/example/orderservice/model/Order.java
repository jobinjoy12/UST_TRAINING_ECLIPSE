package com.example.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders") // 'order' is a reserved keyword in some DBs
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String status; // e.g., PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELED
    private LocalDateTime orderDate;
    private BigDecimal totalAmount;
    private String shippingAddress;
    // TODO: Define items within the order. This could be a separate @ElementCollection or @OneToMany relationship.
    // For simplicity in this conceptual design, we'll keep it basic.

    // Default constructor for JPA
    public Order() {
        this.orderDate = LocalDateTime.now();
    }

    public Order(Long userId, String status, BigDecimal totalAmount, String shippingAddress) {
        this();
        this.userId = userId;
        this.status = status;
        this.totalAmount = totalAmount;
        this.shippingAddress = shippingAddress;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
               "id=" + id +
               ", userId=" + userId +
               ", status='" + status + '\'' +
               ", orderDate=" + orderDate +
               ", totalAmount=" + totalAmount +
               ", shippingAddress='" + shippingAddress + '\'' +
               '}';
    }
}
