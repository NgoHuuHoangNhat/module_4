package com.example.exercise_1.service;

import com.example.exercise_1.model.Blog;
import com.example.exercise_1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    Page<Blog> findAll(Pageable pageable, String tittle);

    void createNewBlog(Blog blog);

    void remove(Integer id);

    Blog findById(Integer id);

    void updateBlog(Blog blog);
}
