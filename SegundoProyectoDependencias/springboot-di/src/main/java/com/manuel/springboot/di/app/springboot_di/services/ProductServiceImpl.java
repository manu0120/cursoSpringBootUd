package com.manuel.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manuel.springboot.di.app.springboot_di.models.Product;
import com.manuel.springboot.di.app.springboot_di.repositories.ProductRepositoryImpl;

/**
 * ProductService - El servicio accede a los datos a través del repositorio, y además trabaja con estos datos para realizar operaciones.
 */
@Component
public class ProductServiceImpl implements ProductService {
    // private ProductRepositoryImpl repository = new ProductRepositoryImpl();
    @Autowired
    private ProductRepositoryImpl repository;
    @Override
    public List<Product> findAll() {
        // return this.repository.findAll().stream().map(p -> {
        //     Double priceImp = p.getPrice() * 1.25d;
        //     p.setPrice(priceImp.longValue());
        //     return p;
        // }).toList();
        return this.repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            // se esta modificando el objeto Product, por lo que se va a mutar el precio original. Mejor clonar el objeto.
            // p.setPrice(priceImp.longValue());

            // Product prod = new Product(p.getId(), p.getName(), priceImp.longValue());
            // return prod;

            Product newProd = (Product) p.clone();
            newProd.setPrice(priceImp.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }
    @Override
    public Product findById(Long id) {
        return this.repository.findById(id);
    }
    
}
