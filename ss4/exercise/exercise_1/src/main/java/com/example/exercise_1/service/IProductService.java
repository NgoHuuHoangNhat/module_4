package com.example.exercise_1.service;

import com.example.exercise_1.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Integer id);

    boolean remove(Integer id);

    Integer findNewId();

    void addNewProduct(Product product);

    void updateProduct(Product product);
}
