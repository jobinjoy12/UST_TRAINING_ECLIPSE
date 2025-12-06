package com.example.demo;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/product")


public class ProductController {

    @Autowired
    public ProductService proSer;

    @PostMapping
    public Product postMethod(@RequestBody Product product) {
        //TODO: process POST request
        
        return proSer.create(product);
    }
    
    @GetMapping
    public List<Product> getMethod() {
        return  proSer.read();
    }
    
    @GetMapping("/{id}")
	public Product findProductById(@PathVariable("id")Integer id) {
		Optional<Product> op = proSer.read(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

    @PutMapping()
    public Product putMethodName(Product product) {
        return proSer.update(product);
    }

    @DeleteMapping("/delete")
    public void deleteMethod(@RequestParam Integer id){
        proSer.delete(id);}
}
