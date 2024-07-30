package com.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.springboot.di.app.springboot_di.models.ProductStore;

public class ProductRepository implements IProducRepository{

    private List<ProductStore> data;
    
    public ProductRepository(){
        this.data = Arrays.asList(
            new ProductStore(1L, "Memoria Corsair 32gb",3000L),
            new ProductStore(2L, "Cpu Intel i10",450L),
            new ProductStore(3L, "Keyboard Redragon XLLL",30L),
            new ProductStore(4L, "Headphones Razer",30L)
        );
    }

    public List<ProductStore> findAll(){
        return data;
    }

    public ProductStore findById(Long id){
        //return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
