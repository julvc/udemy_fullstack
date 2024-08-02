package com.springboot.di.app.springboot_di.repositories;

import java.util.List;

import com.springboot.di.app.springboot_di.models.ProductStore;

public interface IProductRepository {

    List<ProductStore> findAll();
    ProductStore findById(Long id);
}
