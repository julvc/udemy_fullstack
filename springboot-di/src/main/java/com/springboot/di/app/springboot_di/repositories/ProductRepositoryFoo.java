package com.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.di.app.springboot_di.models.ProductStore;


@Repository
public class ProductRepositoryFoo implements IProductRepository{

    @Override
    public List<ProductStore> findAll() {
        return Collections.singletonList(new ProductStore(1L,"PRODUCTO PRUEBA",600L));
    }

    @Override
    public ProductStore findById(Long id) {
        return new ProductStore(id,"PRODUCTO PRUEBA",600L);
    }

}
