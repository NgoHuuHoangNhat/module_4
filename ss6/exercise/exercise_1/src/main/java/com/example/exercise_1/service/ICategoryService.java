package com.example.exercise_1.service;

import com.example.exercise_1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
