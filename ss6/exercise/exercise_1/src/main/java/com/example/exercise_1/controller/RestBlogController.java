package com.example.exercise_1.controller;

import com.example.exercise_1.model.Blog;
import com.example.exercise_1.model.Category;
import com.example.exercise_1.service.IBlogService;
import com.example.exercise_1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blog")
public class RestBlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/list")
    public ResponseEntity<Page<Blog>> getBlogList(@RequestParam(defaultValue = "0") Integer page,
                                                  @RequestParam(defaultValue = "") String search){
        Pageable pageable = PageRequest.of(page,2,Sort.by("postingDate").descending());
        Page<Blog> blogPage = blogService.findAll(pageable,search);
        if(blogPage.getTotalElements() == 0){
            return new ResponseEntity<>(blogPage,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable Integer id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

}
