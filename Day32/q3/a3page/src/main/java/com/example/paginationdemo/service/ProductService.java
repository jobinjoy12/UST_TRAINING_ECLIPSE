package com.example.paginationdemo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.paginationdemo.model.Product;
import com.example.paginationdemo.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> getAllProducts(int page, int size, String sortBy, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase("ascending") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pg = PageRequest.of(0,6,sort);
        return productRepository.findAll(pg);
        // TODO: Create a Sort object based on sortBy and sortDirection
        //  Hint: Use Sort.by() and Sort.Direction.valueOf()
        
        // TODO: Create a Pageable object using PageRequest.of(page, size, sort)

        // TODO: Call the productRepository to find all products with the created Pageable object
         // Race null with the actual repository call
    }

    // Optional: Add a method to save products for testing purposes
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
