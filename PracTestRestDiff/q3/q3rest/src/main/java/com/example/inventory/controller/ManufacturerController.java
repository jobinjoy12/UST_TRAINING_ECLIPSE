package com.example.inventory.controller;

import com.example.inventory.model.Manufacturer;
import com.example.inventory.model.Product;
import com.example.inventory.repository.ManufacturerRepository;
import com.example.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	@Autowired	private ProductRepository productRepository;

	@PostMapping
	public ResponseEntity<Manufacturer> createManufacturer(@RequestBody Manufacturer manufacturer) {
		// Implement logic here to save the manufacturer
		Manufacturer manu = manufacturerRepository.save(manufacturer);
		return new ResponseEntity<>(manu,HttpStatus.CREATED); // Placeholder
	}


	@PostMapping("/{manufacturerId}/products")
	public ResponseEntity<Product> addProductToManufacturer(@PathVariable Long manufacturerId, @RequestBody Product product) {
		Optional<Manufacturer> manu = manufacturerRepository.findById(manufacturerId);
		if(manu.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		product.setManufacturer(manu.get());
		Product pro = productRepository.save(product);
		return new ResponseEntity<>(pro,HttpStatus.CREATED); // Placeholder
	}

	
	@GetMapping("/{manufacturerId}/products")
	public ResponseEntity<List<Product>> getProductsByManufacturer(@PathVariable Long manufacturerId) {
		// Implement logic here
		List<Product> prod = productRepository.findByManufacturerId(manufacturerId);
		
		return new ResponseEntity<>(prod, HttpStatus.OK); // Placeholder
	}

	@GetMapping("/products/priceGreaterThan/{minPrice}")
	public ResponseEntity<List<Product>> getProductsByPriceGreaterThan(@PathVariable BigDecimal minPrice) {
		// Implement logic here
		List<Product> list = productRepository.findByUnitPriceGreaterThan(minPrice);
		return new ResponseEntity<>(list , HttpStatus.OK); // Placeholder
	}
}
