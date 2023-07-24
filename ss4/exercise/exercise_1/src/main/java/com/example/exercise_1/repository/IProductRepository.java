package com.example.exercise_1.repository;

import com.example.exercise_1.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    Product findById(Integer id);

    Product remove(Integer id);

    void addNewProduct(Product product);

    void updateProduct(Product product);
}
