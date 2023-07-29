package com.satya.mongodb.controller;

import com.satya.mongodb.model.Product;
import com.satya.mongodb.repository.service.ProductRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {
    @Autowired
    private ProductRepoService productRepoService;

    @GetMapping("/find-by-code")
    public Product getProduct(@RequestParam String code){
        return productRepoService.findByCode(code);
    }

    @GetMapping("/find-all")
    public List<Product> getAllProducts(){
        return productRepoService.findAllProducts();
    }
}
