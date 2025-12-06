package com.example.restapi.repository;

import com.example.restapi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // TODO: Add any custom repository methods here if needed for more complex queries.
    // For this exercise, basic CRUD operations are handled by JpaRepository.
    
}
