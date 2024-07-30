package com.springboot.di.app.springboot_di.services;

import java.util.List;

import com.springboot.di.app.springboot_di.models.ProductStore;

public interface IProductService {

    List<ProductStore> findAll();
    ProductStore findById(Long id);
}
