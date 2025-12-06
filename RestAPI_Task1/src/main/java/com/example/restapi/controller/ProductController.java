package com.example.restapi.controller;

import com.example.restapi.model.Product;
import com.example.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // TODO: Implement a GET endpoint to retrieve all products.
    //  It should respond to GET requests on "/api/products".
    //  Return a List<Product>.


    // TODO: Implement a GET endpoint to retrieve a product by its ID.
    //  It should respond to GET requests on "/api/products/{id}".
    //  Use @PathVariable to capture the ID.
    //  Return ResponseEntity<Product> with HttpStatus.OK if found, or HttpStatus.NOT_FOUND if not found.


    // TODO: Implement a POST endpoint to create a new product.
    //  It should respond to POST requests on "/api/products".
    //  Use @RequestBody to accept Product object.
    //  Return the created Product with HttpStatus.CREATED.


    // TODO: Implement a PUT endpoint to update an existing product by its ID.
    //  It should respond to PUT requests on "/api/products/{id}".
    //  Use @PathVariable for ID and @RequestBody for the updated Product data.
    //  Return ResponseEntity<Product> with HttpStatus.OK if updated, or HttpStatus.NOT_FOUND if not found.


    // TODO: Implement a DELETE endpoint to delete a product by its ID.
    //  It should respond to DELETE requests on "/api/products/{id}".
    //  Use @PathVariable to capture the ID.
    //  Return ResponseEntity<Void> with HttpStatus.NO_CONTENT if deleted, or HttpStatus.NOT_FOUND if not found.


}
