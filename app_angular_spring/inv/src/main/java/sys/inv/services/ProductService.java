package sys.inv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.inv.models.Product;
import sys.inv.repository.ProductRepository;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product searchById(Integer id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        this.productRepository.deleteById(id);
    }
}
