package com.satya.mongodb.repository;

import com.satya.mongodb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    public Product findByCode(String code);
    public Product findById(int id);
    public List<Product> findAll();
}
