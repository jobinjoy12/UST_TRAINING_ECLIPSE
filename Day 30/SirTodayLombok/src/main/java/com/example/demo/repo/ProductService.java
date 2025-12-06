package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository pr ;
	
	public Product create(Product product)
	{
		return pr.save(product);
	}
	
	public List<Product> read()
	{
		return pr.findAll();
	}
	
	public Optional<Product> read(Integer id) {
		return pr.findById(id);
	}
	
	public Product update(Product product) {
		return pr.save(product);
	}
	
	public void delete(Integer id) {
		pr.deleteById(id);
	}
	
	public List<Product> findRange(Double min , Double max)
	{
		return pr.findPriceRange(min, max);
	}
	
}
