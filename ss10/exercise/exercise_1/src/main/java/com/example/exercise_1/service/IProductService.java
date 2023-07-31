package com.example.exercise_1.service;


import com.example.exercise_1.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
