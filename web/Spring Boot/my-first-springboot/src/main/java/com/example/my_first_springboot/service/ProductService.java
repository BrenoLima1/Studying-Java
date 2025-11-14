package com.example.my_first_springboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.my_first_springboot.model.Product;
import com.example.my_first_springboot.repository.RepositoryProduct;

@Service
public class ProductService {

    private final RepositoryProduct repositoryProduct;

    public ProductService(RepositoryProduct repositoryProduct) {
        this.repositoryProduct = repositoryProduct;
    }

    public List<Product> getAllProducts() {
        return repositoryProduct.findAll();
    }
    
    public Optional<Product> getProductById(Long id) {
        return repositoryProduct.findById(id);
    }

    public Product createProduct(Product product) {
        return repositoryProduct.save(product);
    }

    public void deleteProduct(Long id) {
        repositoryProduct.deleteById(id);
    }
}
