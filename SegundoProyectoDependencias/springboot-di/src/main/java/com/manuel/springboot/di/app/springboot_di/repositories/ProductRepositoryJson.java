package com.manuel.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.manuel.springboot.di.app.springboot_di.models.Product;

import tools.jackson.databind.ObjectMapper;

public class ProductRepositoryJson implements ProductRepository{

    private List<Product> products;
    public ProductRepositoryJson() {
        ClassPathResource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.products = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        // try {
        //     this.products = objectMapper.readValue(resource.getInputStream(), objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
    

    @Override
    public List<Product> findAll() {
        return products.stream().toList();
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
