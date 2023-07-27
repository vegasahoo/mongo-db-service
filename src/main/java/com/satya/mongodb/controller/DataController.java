package com.satya.mongodb.controller;

import com.satya.mongodb.model.Product;
import com.satya.mongodb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/find-by-code")
    public Product getProduct(@RequestParam String code){
        return productRepository.findByCode(code);
    }

    @GetMapping("/find-by-color")
    public List<Product> getProductList(@RequestParam String color){
        return productRepository.findByColor(color);
    }
}
