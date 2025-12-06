package com.example.restapi.service;

import com.example.restapi.model.Item;
import com.example.restapi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // TODO: Implement the following service methods to interact with the ItemRepository.
    // 1. Method to retrieve all items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // 2. Method to retrieve a single item by its ID
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    // 3. Method to create a new item
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    // 4. Method to update an existing item
    public Optional<Item> updateItem(Long id, Item newItemDetails) {
        return itemRepository.findById(id).map(item -> {
            item.setName(newItemDetails.getName());
            item.setDescription(newItemDetails.getDescription());
            return itemRepository.save(item);
        });
    }

    // 5. Method to delete an item by its ID
    public boolean deleteItem(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
