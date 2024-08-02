package com.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.springboot.di.app.springboot_di.models.ProductStore;
import com.springboot.di.app.springboot_di.repositories.IProductRepository;

@Service
public class ProductService implements IProductService{

    @Autowired
    private Environment environment;

    @Value("${config.tax.price}")
    private Double tax;
    @Autowired
    private IProductRepository repository;

    public List<ProductStore> findAll(){
        return repository.findAll().stream().map(p-> {
            Double priceImp = p.getPrice()* environment.getProperty("config.tax.price",Double.class);
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
