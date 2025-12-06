package com.example.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

// TODO: Annotate this class as a JPA Entity
// TODO: Use Lombok's @Data, @NoArgsConstructor, and @AllArgsConstructor for boilerplate code
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    // TODO: Define the 'id' field as the primary key, auto-generated.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Define 'name' field
    private String name;

    // TODO: Define 'description' field
    private String description;

    // TODO: Define 'price' field
    private double price;

    public Product(String name , String desc ,  double price)
    {
        this.name = name;
        this.description=desc;
        this.price=price;
    }
}
