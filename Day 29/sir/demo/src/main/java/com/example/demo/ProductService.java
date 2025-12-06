package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    public ProductRepository productRepo;

    public Product create(Product pro){
        return productRepo.save(pro);
    }

    public Product update(Product pro){
        return productRepo.save(pro);

    }

    public List<Product> read(){
        return productRepo.findAll();
    }

    public Optional<Product> read(Integer id){
        return productRepo.findById(id);
    }

    public void delete(Integer id){
        productRepo.deleteById(id);
    }
}
