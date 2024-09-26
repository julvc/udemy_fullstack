package sys.inv.services;

import java.util.List;

import sys.inv.models.Product;

public interface IProductService {

    public List<Product> listProducts();
    public Product searchById(Integer id);
    public Product addProduct(Product product);
    public void deleteProduct(Integer id);
}
