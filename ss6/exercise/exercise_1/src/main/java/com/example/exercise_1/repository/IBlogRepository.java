package com.example.exercise_1.repository;

import com.example.exercise_1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findBlogByTittleContaining(Pageable pageable, String tittle);
}
