package com.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.springboot.di.app.springboot_di.models.ProductStore;
import com.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService implements IProductService{

    private ProductRepository repository = new ProductRepository();

    public List<ProductStore> findAll(){
        return repository.findAll().stream().map(p-> {
            Double priceImp = p.getPrice()*1.19d;
            //ProductStore newProduct = new ProductStore(p.getId(),p.getName(), priceImp.longValue());          
            ProductStore newProduct = (ProductStore)p.clone();
            newProduct.setPrice(priceImp.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    public ProductStore findById(Long id){
        return repository.findById(id);
    }
}
