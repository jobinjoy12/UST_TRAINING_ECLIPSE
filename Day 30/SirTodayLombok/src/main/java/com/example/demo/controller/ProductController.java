package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.SirTodayLombokApplication;
import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;
import com.example.demo.repo.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final SirTodayLombokApplication sirTodayLombokApplication;
	
	@Autowired
	private ProductService ps ;

	@Autowired 
	private ProductRepository pr;

    ProductController(SirTodayLombokApplication sirTodayLombokApplication) {
        this.sirTodayLombokApplication = sirTodayLombokApplication;
    }
	
	
	@GetMapping
	public List<Product> getProducts()
	{
		return ps.read();
	}
	
	@GetMapping("/{id}")
	public Optional<Product> getById(@PathVariable("id")Integer id)
	{
		return ps.read(id);
	}
	
	@PostMapping
	public Product createPro(@RequestBody Product pro) {
		System.out.println("request body is added");
		System.out.println(pro);
		return ps.create(pro);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable("id")Integer id ,@RequestBody Product pro )
	{
		return ps.update(pro);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id")Integer id)
	{
		 ps.delete(id);
	}
	
	@GetMapping("/category/{category}")
	public List<Product> findByCategory(@PathVariable("category") String category)
	{
		return pr.findByCategory(category);
		
	}
	
	@GetMapping("/pricerange/{min}/{max}")
	public List<Product> findProductPriceRange(@PathVariable("min") Double from , @PathVariable("max") Double to)
	{
		return ps.findRange(from, to);
	}
}
