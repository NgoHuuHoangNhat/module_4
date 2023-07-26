package com.example.exercise_1.controller;

import com.example.exercise_1.model.Blog;
import com.example.exercise_1.service.IBlogService;
import com.example.exercise_1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/list")
    public ModelAndView showList(@RequestParam(defaultValue = "0") Integer page,
                                 @RequestParam(defaultValue = "") String searchTittle) {
        ModelAndView modelAndView = new ModelAndView("list");
        Pageable pageable = PageRequest.of(page,2, Sort.by("postingDate").descending());
        Page<Blog> blogPage = blogService.findAll(pageable,searchTittle);
        modelAndView.addObject("blogPage",blogPage);
        modelAndView.addObject("searchTittle",searchTittle);
        return modelAndView;
    }
    @GetMapping("/write-new-blog-form")
    public ModelAndView showNewBlogForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog",new Blog());
        modelAndView.addObject("categoryList",categoryService.findAll());
        return modelAndView;
    }
    @PostMapping("/write-new-blog")
    public String createNewBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blog.setPostingDate(Date.valueOf(LocalDate.now()));
        blogService.createNewBlog(blog);
        redirectAttributes.addFlashAttribute("msg","successfully");
        return "redirect:/blog/list";
    }
    @PostMapping("/delete")
    public String deleteBlog(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("msg","delete successfully");
        return "redirect:/blog/list";
    }

    @PostMapping("/edit-form")
    public String editBlogForm(@RequestParam Integer id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("categoryList",categoryService.findAll());
        model.addAttribute("blog", blog);
        return "edit";
    }
    @PostMapping("/edit-blog")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blog.setPostingDate(Date.valueOf(LocalDate.now()));
        blogService.updateBlog(blog);
        redirectAttributes.addFlashAttribute("msg","Update successfully");
        return "redirect:/blog/list";
    }
    @GetMapping("/info/{id}")
    public ModelAndView showInfoBlog(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("info");
        Blog blog = blogService.findById(id);
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }
}
