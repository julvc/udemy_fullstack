package com.springboot.di.app.springboot_di.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.di.app.springboot_di.models.ProductStore;
import com.springboot.di.app.springboot_di.services.ProductService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/apiDi")
public class ProductController {

    private ProductService service = new ProductService();

    @GetMapping
    public List<ProductStore> list() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public ProductStore show(@PathVariable Long id) {
        return service.findById(id);
    }
    
}
