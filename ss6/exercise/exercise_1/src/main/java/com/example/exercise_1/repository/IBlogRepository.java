package com.example.exercise_1.repository;

import com.example.exercise_1.model.Blog;
import com.example.exercise_1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

}
