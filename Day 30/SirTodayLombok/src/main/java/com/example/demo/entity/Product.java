package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id ;
	private String category;
	private String name ;
	private Double price ;
}
