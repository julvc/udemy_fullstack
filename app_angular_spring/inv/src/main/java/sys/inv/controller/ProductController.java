package sys.inv.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sys.inv.models.Product;
import sys.inv.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("inventory-app")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        List<Product> products = this.productService.listProducts();
        logger.info("Productos obtenidos");
        products.forEach((product -> logger.info(product.toString())));
        return products;
    }

    
    


}
