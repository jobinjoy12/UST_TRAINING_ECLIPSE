package com.example.productapi;

import com.example.productapi.model.Product;
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

    @Test
    void testCreateProduct() {
        Product newProduct = new Product(null, "Keyboard", 75.0);

        ResponseEntity<Product> response = restTemplate.postForEntity("/api/products", newProduct, Product.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("Keyboard");
    }

    @Test
    void testGetAllProducts() {
        ResponseEntity<Product[]> response = restTemplate.getForEntity("/api/products", Product[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    void testUpdateProduct() {
        Product newProduct = new Product(null, "Mouse", 25.0);
        Product createdProduct = restTemplate.postForEntity("/api/products", newProduct, Product.class).getBody();

        createdProduct.setPrice(30.0);
        restTemplate.put("/api/products/" + createdProduct.getId(), createdProduct);

        ResponseEntity<Product> response = restTemplate.getForEntity("/api/products/" + createdProduct.getId(), Product.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getPrice()).isEqualTo(30.0);
    }

    @Test
    void testDeleteProduct() {
        Product newProduct = new Product(null, "Monitor", 150.0);
        Product createdProduct = restTemplate.postForEntity("/api/products", newProduct, Product.class).getBody();

        restTemplate.delete("/api/products/" + createdProduct.getId());

        ResponseEntity<Product> response = restTemplate.getForEntity("/api/products/" + createdProduct.getId(), Product.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}