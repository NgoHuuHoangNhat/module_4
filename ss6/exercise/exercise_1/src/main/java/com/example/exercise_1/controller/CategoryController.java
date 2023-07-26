package com.example.exercise_1.controller;

import com.example.exercise_1.model.Category;
import com.example.exercise_1.service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView showListCategory(@RequestParam(defaultValue = "0") Integer page,
                                         @RequestParam(defaultValue = "") String searchCategory){
        Pageable pageable = PageRequest.of(page,2, Sort.by("id").ascending());
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("pageCategory",categoryService.findAllByName(pageable,searchCategory));
        modelAndView.addObject("searchCategory",searchCategory);
        return modelAndView;
    }
    @PostMapping("/edit-form")
    public ModelAndView showEditForm(@RequestParam Integer id){
        ModelAndView modelAndView = new ModelAndView("category/edit");
        Category category = categoryService.findCategoryById(id);
        modelAndView.addObject("category",category);
        return modelAndView;
    }
    @PostMapping("/edit")
    public String editCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.saveCategory(category);
        redirectAttributes.addFlashAttribute("msg","Update Successfully");
        return "redirect:/category/list";
    }
    @GetMapping("/create-form")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category",new Category());
        return modelAndView;
    }
    @PostMapping("/create")
    public String createCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.saveCategory(category);
        redirectAttributes.addFlashAttribute("msg","Create Successfully");
        return "redirect:/category/list";
    }
    @GetMapping("/show-blog/{id}")
    public ModelAndView showBlog(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("category/info");
        modelAndView.addObject("category", categoryService.findCategoryById(id));
        return modelAndView;
    }
}
