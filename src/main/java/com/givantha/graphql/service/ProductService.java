package com.givantha.graphql.service;

import com.givantha.graphql.entity.Product;
import com.givantha.graphql.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Product updateStock(int id, int updatedStock) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found : "+id));
        product.setStock(updatedStock);
        return productRepository.save(product);
    }
}
