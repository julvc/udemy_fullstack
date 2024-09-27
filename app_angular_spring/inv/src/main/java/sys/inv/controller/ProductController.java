package sys.inv.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sys.inv.exceptions.ResourceNotFoundException;
import sys.inv.models.Product;
import sys.inv.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

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

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        logger.info("Producto a agregar: " + product);
        return this.productService.addProduct(product);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        logger.info("Id de producto a buscar " + id);
        Product product = this.productService.searchById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            throw new ResourceNotFoundException("No se encontro el producto escogido");
        }
    }
    
    @PutMapping("products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product entity) {
        Product product = this.productService.searchById(id);
        if (product != null) {
            product.setDescription(entity.getDescription());
            product.setPrice(entity.getPrice());
            product.setTotal(entity.getTotal());
            this.productService.addProduct(product);
            return ResponseEntity.ok(product);
        } else {
            throw new ResourceNotFoundException("No se pudo actualizar el producto escogido " + entity.toString());
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteProduct(@PathVariable int id) {
        logger.info("Id de producto a eliminar " + id);
        Product product = this.productService.searchById(id);
        if (product != null) {
            this.productService.deleteProduct(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("Producto eliminado", Boolean.TRUE);
            return ResponseEntity.ok(response);
        } else {
            throw new ResourceNotFoundException("No se pudo eliminar el producto escogido " + id);
        }
    }

    


}
