package com.satya.mongodb.repository.service;

import com.satya.mongodb.model.Product;
import com.satya.mongodb.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
public class ProductRepoService {

    private Logger logger = LoggerFactory.getLogger(ProductRepoService.class);
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RedisTemplate<String, Product> redisTemplate;

    public Product findByCode(String code){
        Product product = redisTemplate.opsForValue().get(code);
        if (product != null){
            logger.info("Fetched from Redis Cache");
        }
        else{
            product = productRepository.findByCode(code);
            if(product!= null){
                logger.info("Data fetched from DB");
                redisTemplate.opsForValue().set(code, product);
                logger.info("Data updated in Redis Cache");
            }
            else{
                logger.info("Product not available");
            }
        }
        return product;
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

}
