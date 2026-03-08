package com.manuel.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.manuel.springboot.di.app.springboot_di.models.Product;
import com.manuel.springboot.di.app.springboot_di.repositories.ProductRepository; 

/**
 * ProductService - El servicio accede a los datos a través del repositorio, y además trabaja con estos datos para realizar operaciones.
 */
@Service
public class ProductServiceImpl implements ProductService {
    // private ProductRepositoryImpl repository = new ProductRepositoryImpl();
    
    @Autowired
    @Qualifier("productList")
    // @Qualifier("productRepositoryJson")
    private ProductRepository repository;
    // con el constructor no hace falta el @Autowired
    // public ProductServiceImpl(@Qualifier("productFoo") ProductRepository repository) {
    //     this.repository = repository;
    // }
    
    /*
    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }
    */

    @Value("${productTax}")
    private int taxPercentage;

    @Override
    public List<Product> findAll() {
        // return this.repository.findAll().stream().map(p -> {
        //     Double priceImp = p.getPrice() * 1.25d;
        //     p.setPrice(priceImp.longValue());
        //     return p;
        // }).toList();
        return this.repository.findAll().stream().map(p -> {
            // Double priceImp = p.getPrice() * 1.25d;
            System.out.println("Precio antes de impuesto: " + p.getPrice());
            Double priceImp = p.getPrice() * (taxPercentage / 100d + 1);
            System.out.println("Precio con impuesto: " + priceImp);
            System.out.println("------------------------------");
            // se esta modificando el objeto Product, por lo que se va a mutar el precio original. Mejor clonar el objeto.
            // p.setPrice(priceImp.longValue());

            // Product prod = new Product(p.getId(), p.getName(), priceImp.longValue());
            // return prod;

            Product newProd = (Product) p.clone();
            newProd.setPrice(priceImp.longValue());
            return newProd;
            // Esto se usaba para explicar que se debe clonar el objeto para no mutar el original. Se evitaba esto con el uso de @RequestScope
            // p.setPrice(priceImp.longValue());
            // return p;
        }).collect(Collectors.toList());
    }
    @Override
    public Product findById(Long id) {
        return this.repository.findById(id);
    }
}
