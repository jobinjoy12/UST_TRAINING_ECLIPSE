package com.example.demo.repo;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByCategory(String category);
	
	@Query(value = "from Product p where p.price between :min and :max",nativeQuery = false)
	List<Product> findPriceRange(@Param("min")Double min , @Param("max")Double max);
}
