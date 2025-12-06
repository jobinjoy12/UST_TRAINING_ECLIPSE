package com.example.inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private BigDecimal unitPrice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manufacturer_id")
	@JsonIgnore // Prevent infinite recursion in JSON serialization
	private Manufacturer manufacturer;
}
