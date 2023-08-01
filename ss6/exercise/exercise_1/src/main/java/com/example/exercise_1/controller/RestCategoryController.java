package com.example.exercise_1.controller;

import com.example.exercise_1.model.Blog;
import com.example.exercise_1.model.Category;
import com.example.exercise_1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/category")
public class RestCategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/list")
    public ResponseEntity<Page<Category>> getCategoryList(@RequestParam(defaultValue = "0") Integer page,
                                                          @RequestParam(defaultValue = "") String search){
        Pageable pageable = PageRequest.of(page,2, Sort.by("name").ascending());
        Page<Category> categoryPage = categoryService.findAllByName(pageable,search);
        if(categoryPage.getTotalElements() == 0){
            return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryPage,HttpStatus.OK);
    }
    @GetMapping("/show-blog/{id}")
    public ResponseEntity<Set<Blog>> getBlogListInCategory(@PathVariable Integer id){
        Category category = categoryService.findCategoryById(id);
        if(category == null || category.getBlogSet().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(category.getBlogSet(),HttpStatus.OK);
    }

}
