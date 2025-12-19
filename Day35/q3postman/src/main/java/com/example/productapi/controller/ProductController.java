package com.example.productapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productapi.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final Map<Long, Product> products = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public void clearProducts() {
        products.clear();
        idCounter.set(0L);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
   
        product.setId(idCounter.incrementAndGet());
        products.put(product.getId(),product);
        
        return new ResponseEntity<>(product, HttpStatus.CREATED); 
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
     
        List<Product> list = new ArrayList<>();
        list = products.values().stream().toList();
        return new ResponseEntity<>(list, HttpStatus.OK); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    
        if(products.containsKey(id))
        {
            return new ResponseEntity<>(products.get(id),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {

        if(products.containsKey(id))
        {
           Product p =  products.get(id);
           p.setName(product.getName());
           p.setPrice(product.getPrice());
            return new ResponseEntity<>(p,HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
       
        if(products.containsKey(id))
        {
            products.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }
}