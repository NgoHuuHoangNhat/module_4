package com.example.exercise_1.service;

import com.example.exercise_1.model.Product;
import com.example.exercise_1.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    public IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean remove(Integer id) {
        Product product = productRepository.remove(id);
        return product != null;
    }

    @Override
    public Integer findNewId() {
        return productRepository.findNewId();
    }

    @Override
    public void addNewProduct(Product product) {
        product.setId(findNewId());
        productRepository.addNewProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }
}
