package com.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.di.app.springboot_di.models.ProductStore;

public class ProductRepositoryJson implements IProductRepository{

    private List<ProductStore> list;

    public ProductRepositoryJson(){
        Resource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getFile(), ProductStore[].class));
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductStore> findAll() {
        return list;
    }

    @Override
    public ProductStore findById(Long id) {
        return list.stream().filter(p-> p.getId().equals(id)).findFirst().orElseThrow();
    }

}
