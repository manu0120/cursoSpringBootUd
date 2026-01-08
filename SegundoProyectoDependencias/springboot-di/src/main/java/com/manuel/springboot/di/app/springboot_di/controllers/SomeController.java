package com.manuel.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manuel.springboot.di.app.springboot_di.models.Product;
import com.manuel.springboot.di.app.springboot_di.services.ProductService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class SomeController {
    /* si 'service' se queda como variable de instancia, se va a crear una sola instancia de ProductService
     * y se va a compartir entre todos los métodos de este controlador. Lo que va a provocar que por ejemplo
     * cuando se llame al método 'findAll' se va a aplicar el impuesto al precio de cada producto y no se va
     * resetear. Cada vez que se llame va a ir sumando el impuesto al precio de cada producto. Se tendría que 
     * aplicar el impuesto sobre el precio base. Para que no mute el objeto se va a modificar findAll del service.
     */
    private ProductService service = new ProductService();

    @GetMapping
    public List<Product> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product showProduct(@PathVariable Long id) {
        return service.findById(id);
    }
    
}
