package com.example.productcatalog.service;

import com.example.productcatalog.exception.DuplicateProductNameException;
import com.example.productcatalog.exception.ProductNotFoundException;
import com.example.productcatalog.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    @Value("${product.data.file:products.json}")
    private String dataFilePath;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void loadProductsOnStartup() {
        loadProductsFromFile();
    }

    @PreDestroy
    public void saveProductsOnShutdown() {
        saveProductsToFile();
    }

    // TODO: Implement the logic to retrieve all products.
    // Return the list of all products currently in the catalog.
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    // TODO: Implement the logic to find a product by its ID.
    // Throw ProductNotFoundException if the product does not exist.
    public Optional<Product> getProductById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    // TODO: Implement the logic to add a new product.
    // 1. Before adding, check if a product with the same name already exists (case-insensitive).
    // 2. If a duplicate name is found, throw DuplicateProductNameException.
    // 3. Otherwise, assign a unique ID to the new product using 'nextId' and add it to the catalog.
    public Product addProduct(Product product) {
        // Check for duplicate product name
        boolean nameExists = products.stream()
                .anyMatch(p -> p.getName().equalsIgnoreCase(product.getName()));
        if (nameExists) {
            throw new DuplicateProductNameException("Product with name '" + product.getName() + "' already exists.");
        }

        // Assign unique ID
        product.setId(nextId.getAndIncrement());
        products.add(product);
        return product;
    }

    // TODO: Implement the logic to update an existing product's details.
    // 1. Find the product by ID.
    // 2. If the product is not found, throw ProductNotFoundException.
    // 3. If the name is being changed, ensure the new name does not conflict with another existing product's name (excluding the current product itself).
    // 4. Update all relevant fields (name, category, price, stockQuantity).
    public Product updateProduct(int id, Product updatedProduct) {
        return getProductById(id).map(existingProduct -> {
            if (!existingProduct.getName().equalsIgnoreCase(updatedProduct.getName())) {
                // Check for duplicate name if name is being changed
                boolean nameExists = products.stream()
                        .filter(p -> p.getId() != id)
                        .anyMatch(p -> p.getName().equalsIgnoreCase(updatedProduct.getName()));
                if (nameExists) {
                    throw new DuplicateProductNameException("Product with name '" + updatedProduct.getName() + "' already exists.");
                }
            }
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setStockQuantity(updatedProduct.getStockQuantity());
            return existingProduct;
        }).orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found."));
    }

    // TODO: Implement the logic to remove a product by its ID.
    // Throw ProductNotFoundException if the product does not exist.
    public void deleteProduct(int id) {
        boolean removed = products.removeIf(p -> p.getId() == id);
        if (!removed) {
            throw new ProductNotFoundException("Product with ID " + id + " not found.");
        }
    }

    // TODO: Implement the logic to filter products by category.
    // Return a list of products belonging to the specified category.
    public List<Product> filterProductsByCategory(String category) {
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // TODO: Implement the logic to sort products by price in descending order.
    // Return a list of all products sorted by price from highest to lowest.
    public List<Product> sortProductsByPriceDesc() {
        return products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());
    }

    // TODO: Implement the logic for flexible updates (PATCH).
    // 1. Find the product by ID.
    // 2. If the product is not found, throw ProductNotFoundException.
    // 3. Update only the provided fields (name, price, stockQuantity). Null fields in `productDetails` should be ignored.
    // 4. If the name is updated, perform the duplicate name check.
    public Product patchProduct(int id, Product productDetails) {
        return getProductById(id).map(existingProduct -> {
            if (productDetails.getName() != null && !productDetails.getName().isEmpty()) {
                if (!existingProduct.getName().equalsIgnoreCase(productDetails.getName())) {
                    // Check for duplicate name if name is being changed
                    boolean nameExists = products.stream()
                            .filter(p -> p.getId() != id)
                            .anyMatch(p -> p.getName().equalsIgnoreCase(productDetails.getName()));
                    if (nameExists) {
                        throw new DuplicateProductNameException("Product with name '" + productDetails.getName() + "' already exists.");
                    }
                }
                existingProduct.setName(productDetails.getName());
            }
            if (productDetails.getPrice() > 0) {
                existingProduct.setPrice(productDetails.getPrice());
            }
            if (productDetails.getStockQuantity() >= 0) {
                existingProduct.setStockQuantity(productDetails.getStockQuantity());
            }
            return existingProduct;
        }).orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found."));
    }

    // TODO: Implement the logic to get the total number of products.
    public int getTotalProducts() {
        return products.size();
    }

    // TODO: Implement the logic to clear all products from the catalog.
    public void clearAllProducts() {
        products.clear();
        nextId.set(1); // Reset ID counter
    }

    // TODO: Implement the logic to load product data from a JSON file.
    // Use ObjectMapper to read `dataFilePath`. Handle potential IOException.
    // Ensure `nextId` is updated based on the max ID loaded.
    private void loadProductsFromFile() {
        File file = new File(dataFilePath);
        if (file.exists() && file.length() > 0) {
            try {
                List<Product> loadedProducts = objectMapper.readValue(file, new TypeReference<List<Product>>() {});
                products.clear();
                products.addAll(loadedProducts);
                int maxId = products.stream()
                        .mapToInt(Product::getId)
                        .max()
                        .orElse(0);
                nextId.set(maxId + 1);
            } catch (IOException e) {
                System.err.println("Error loading products from file: " + e.getMessage());
            }
        } else {
            System.out.println("No existing product data file found or file is empty. Starting with an empty catalog.");
        }
    }

    // TODO: Implement the logic to save product data to a JSON file.
    // Use ObjectMapper to write the current 'products' list to `dataFilePath`. Handle potential IOException.
    private void saveProductsToFile() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(dataFilePath), products);
            System.out.println("Product data saved to " + dataFilePath);
        } catch (IOException e) {
            System.err.println("Error saving products to file: " + e.getMessage());
        }
    }
}


// package com.example.productcatalog.service;

// import java.io.File;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Comparator;
// import java.util.List;
// import java.util.Optional;
// import java.util.concurrent.atomic.AtomicInteger;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;

// import com.example.productcatalog.model.Product;
// import com.fasterxml.jackson.core.type.TypeReference;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.annotation.PostConstruct;
// import jakarta.annotation.PreDestroy;

// @Service
// public class ProductService {

//     private final List<Product> products = new ArrayList<>();
//     private final AtomicInteger nextId = new AtomicInteger(1);

//     @Value("${product.data.file:products.json}")
//     private String dataFilePath;

//     private final ObjectMapper objectMapper = new ObjectMapper();

//     @PostConstruct
//     public void loadProductsOnStartup() {
//         // TODO: load products from file
//     }

//     @PreDestroy
//     public void saveProductsOnShutdown() {
//         // TODO: save products to file
//     }

//     // TODO: retrieve all products
//     public List<Product> getAllProducts() {
//         return products;
//     }

//     // TODO: find product by ID
//     public Optional<Product> getProductById(int id) {
//         return products.stream().filter(s->s.getId()==id).findFirst();
//     }

//     // TODO: add new product
//     public Product addProduct(Product product) {
//        if(!products.stream().anyMatch(s->s.getId()==product.getId()))
//        {
//             products.add(product);
//             return product ; 
//        }
//         return null;
//     }

//     // TODO: update product by ID
//     public Product updateProduct(int id, Product updatedProduct) {

//         return getProductById(id).map(s->{
//             s.setName(updatedProduct.getName());
//             s.setPrice(updatedProduct.getPrice());
//             s.setCategory(updatedProduct.getCategory());
//             s.setStockQuantity(updatedProduct.getStockQuantity());
//             return s;
//         }).orElseThrow(()->new RuntimeException("Id does not exist"));
//     }

//     // TODO: delete product by ID
//     public void deleteProduct(int id) {
//         if(getProductById(id).isPresent())
//         {
//             products.remove(getProductById(id).get());
//         }
//         // TODO: implement delete logic
//     }

//     // TODO: filter products by category
//     public List<Product> filterProductsByCategory(String category) {
        
//         return products.stream().filter(s->s.getCategory()==category).toList();
//     }

//     // TODO: sort products by price descending
//     public List<Product> sortProductsByPriceDesc() {
        
//         return products.stream().sorted(Comparator.comparingDouble(Product::getPrice)).collect(Collectors.toList());
//     }

//     // TODO: patch product (flexible update)
//     public Product patchProduct(int id, Product productDetails) {
//         Product p = getProductById(id).get();
//         if(productDetails.getName()!=null)
//         {
//             p.setName(productDetails.getName());
//         }
//         if(productDetails.getCategory()!=null)
//         {
//             p.setCategory(productDetails.getCategory());
//         }
//         if(productDetails.getPrice()>0)
//         {
//             p.setPrice(productDetails.getPrice());
//         }
//         if(productDetails.getStockQuantity()>0)
//         {
//             p.setStockQuantity(productDetails.getStockQuantity());
//         }
//         return p ;
//     }

//     // TODO: get total number of products
//     public int getTotalProducts() {
//         return products.size()
//         ;
//     }

//     // TODO: clear all products
//     public void clearAllProducts() {
//         // TODO: implement clear logic
//         products.clear();
//     }

//     // TODO: load products from JSON file
//     private void loadProductsFromFile() throws IOException{
//         // TODO: implement file loading
//         File file = new File(dataFilePath);
//         if(file.length()>0 && file.exists())
//         {
//             try{

//            List<Product> lst = objectMapper.readValue(file, new TypeReference<List<Product>>() {});
//            products.clear();
//            products.addAll(lst);
//            int max  = lst.stream().mapToInt(Product::getId).max().orElse(0);
//            nextId.set(max+1);
//             }catch(IOException e){System.out.println("File not found");};
            
//         }

//     }

//     // TODO: save products to JSON file
//     private void saveProductsToFile() throws IOException {
//         try
//         {objectMapper.writeValue(new File(dataFilePath),products);
            
//         }catch(IOException e){System.out.println("location empty");
//         }

//         // TODO: implement file saving
//     }
// }