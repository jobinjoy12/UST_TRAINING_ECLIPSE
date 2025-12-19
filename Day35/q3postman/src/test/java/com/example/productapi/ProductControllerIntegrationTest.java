package com.example.productapi;

import com.example.productapi.controller.ProductController;
import com.example.productapi.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductController productController; // Inject controller to clear its in-memory state

    @BeforeEach
    void setUp() {
        productController.clearProducts(); // Clear products before each test
    }

    @Test
    void testCreateProduct() {
        // Given
        Product newProduct = new Product(null, "Keyboard", 75.0);

        // When
        ResponseEntity<Product> response = restTemplate.postForEntity("/api/products", newProduct, Product.class);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("Keyboard");
        assertThat(response.getBody().getPrice()).isEqualTo(75.0);
    }

    @Test
    void testGetAllProductsInitiallyEmpty() {
        // TODO: Implement test for GET /api/products when no products exist.
        // Verify that an empty list is returned and HTTP Status 200 OK.
    }

    @Test
    void testGetAllProductsAfterCreation() {
        // TODO: Implement test for GET /api/products after creating one or more products.
        // Create products via POST, then retrieve all and assert the list contains the created products.
        // Assert HTTP Status 200 OK.
    }

    @Test
    void testGetProductByIdFound() {
        // TODO: Implement test for GET /api/products/{id} for an existing product.
        // First create a product via POST to get an ID.
        // Then retrieve it by ID and assert it's the correct product and HTTP Status 200 OK.
    }

    @Test
    void testGetProductByIdNotFound() {
        // TODO: Implement test for GET /api/products/{id} for a non-existent product.
        // Assert HTTP Status 404 Not Found.
    }

    @Test
    void testUpdateProductSuccess() {
        // TODO: Implement test for PUT /api/products/{id} for an existing product.
        // Create a product, then update its details (name, price) via PUT.
        // Assert the response is the updated product, HTTP Status 200 OK, and verify the changes via a subsequent GET.
    }

    @Test
    void testUpdateProductNotFound() {
        // TODO: Implement test for PUT /api/products/{id} for a non-existent product.
        // Assert HTTP Status 404 Not Found.
    }

    @Test
    void testDeleteProductSuccess() {
        // TODO: Implement test for DELETE /api/products/{id} for an existing product.
        // Create a product, then delete it.
        // Assert HTTP Status 204 No Content.
        // Verify the product is no longer retrievable (subsequent GET returns 404).
    }

    @Test
    void testDeleteProductNotFound() {
        // TODO: Implement test for DELETE /api/products/{id} for a non-existent product.
        // Assert HTTP Status 404 Not Found.
    }
}