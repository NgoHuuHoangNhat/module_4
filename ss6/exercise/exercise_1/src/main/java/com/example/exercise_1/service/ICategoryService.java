package com.example.exercise_1.service;

import com.example.exercise_1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Page<Category> findAllByName(Pageable pageable, String searchCategory);

    Category findCategoryById(Integer id);

    void saveCategory(Category category);
}
