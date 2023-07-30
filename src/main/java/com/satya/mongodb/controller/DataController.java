package com.satya.mongodb.controller;

import com.satya.mongodb.model.Product;
import com.satya.mongodb.repository.service.ProductRepoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    private Logger logger = LoggerFactory.getLogger(DataController.class);
    @Autowired
    private ProductRepoService productRepoService;

    @GetMapping("/health-check")
    public String healthCheck() {
        logger.info("alive");
        return "alive";
    }

    @GetMapping("/find-by-code")
    public Product getProduct(@RequestParam String code){
        return productRepoService.findByCode(code);
    }

    @GetMapping("/find-all")
    public List<Product> getAllProducts(){
        return productRepoService.findAllProducts();
    }
}
