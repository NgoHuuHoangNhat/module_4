package com.example.exercise_1.service;

import com.example.exercise_1.model.Blog;
import com.example.exercise_1.model.Category;
import com.example.exercise_1.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();

    }

    @Override
    public void createNewBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(Integer id) {
       return blogRepository.findById(id).get();
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepository.save(blog);
    }


}
