package com.contrerasjose.ecommercemanagement.ecommercemgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contrerasjose.ecommercemanagement.ecommercemgt.entity.MyMerchandiseList;
import com.contrerasjose.ecommercemanagement.ecommercemgt.repository.MyMerchandiseRepository;

@Service
public class MyMerchandiseService {

    @Autowired
    private MyMerchandiseRepository repository;

    // Method to save an item in MyMerchandiseList
    public void saveMyMerch(MyMerchandiseList myMerchandise) {
        repository.save(myMerchandise); // Persist the item to the database
    }

    // Method to fetch all items in MyMerchandiseList
    public List<MyMerchandiseList> getAllMyMerch() {
        return repository.findAll(); // Retrieve all items from the repository
    }

    // Method to delete an item by ID from MyMerchandiseList
    public void deleteById(int id) {
        repository.deleteById(id); // Delete the item from the repository using its ID
    }
}
