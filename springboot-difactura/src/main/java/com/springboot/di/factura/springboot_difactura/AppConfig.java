package com.springboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.springboot.di.factura.springboot_difactura.models.Item;
import com.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF8")
public class AppConfig {

    //@Primary
    @Bean
    List<Item> itemsInvoice(){
        Product p1 = new Product("Sony psp", 150000);
        Product p2 = new Product("Sony go", 156000);
        List<Item> items = Arrays.asList(new Item(p1,2),new Item(p2,4));
        
        return items;
    }

    @Bean("default")
    List<Item> itemsInvoiceOffice(){
        Product p1 = new Product("Monitor Xiaomi", 195000);
        Product p2 = new Product("Laptop Lenovo", 9000000);
        Product p3 = new Product("Teclado Cougar", 90000);
        Product p4 = new Product("Silla ejecutiva", 500000);
        List<Item> items = Arrays.asList(new Item(p1,6),new Item(p2,6),new Item(p3,6),new Item(p4,6));
        
        return items;
    }
}
