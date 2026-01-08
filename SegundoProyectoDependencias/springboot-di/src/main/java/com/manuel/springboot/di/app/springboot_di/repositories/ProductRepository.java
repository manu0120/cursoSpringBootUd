package com.manuel.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.manuel.springboot.di.app.springboot_di.models.Product;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria RAM", 50L),
            new Product(2L, "Disco Duro", 200L),
            new Product(3L, "Procesador", 300L),
            new Product(4L, "Tarjeta Grafica", 1000L)
        );
        // this.data = List.of(
        // new Product(1L, "Memoria RAM", 50),
        // new Product(2L, "Disco Duro", 200),
        // new Product(3L, "Procesador", 300),
        // new Product(4L, "Tarjeta Grafica", 1000)
        // );
    }

    public List<Product> findAll() {
        return this.data;
    }

    public void save(Product product) {
        this.data.add(product);
    }

    public void deleteById(Long id) {
        this.data.removeIf(p -> p.getId().equals(id));
    }

    public Product findById(Long id) {
        // return this.data.stream()
        //         .filter(p -> p.getId().equals(id))
        //         .findFirst()
        //         .orElse(null);
        return this.data.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

}
