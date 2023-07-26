package com.example.exercise_1.service;

import com.example.exercise_1.model.Category;
import com.example.exercise_1.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private
    ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAllByName(Pageable pageable, String searchCategory) {
        return categoryRepository.findAllByNameContains(pageable,searchCategory);
    }

    @Override
    public Category findCategoryById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
}
