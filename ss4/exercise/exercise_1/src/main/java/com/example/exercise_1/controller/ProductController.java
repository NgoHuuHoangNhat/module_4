package com.example.exercise_1.controller;

import com.example.exercise_1.model.Product;
import com.example.exercise_1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    public IProductService productService;
    @GetMapping("/list")
    public ModelAndView displayList(){
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> productList = productService.findAll();
        modelAndView.addObject("productList",productList);
        return modelAndView;
    }
    @GetMapping("/delete/form/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("delete");
        Product product = productService.findById(id);
        modelAndView.addObject("product",product);
        return modelAndView;
    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        boolean flag = productService.remove(id);
        if(flag){
            redirectAttributes.addFlashAttribute("msg","Delete successfully!");
            return "redirect:/product/list";
        }else {

            return "error404";
        }
    }
    @GetMapping("/create/form")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.addNewProduct(product);
        redirectAttributes.addFlashAttribute("msg","Successfully!");
        return "redirect:/product/list";
    }
    @GetMapping("/edit/form/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("edit");
        Product product = productService.findById(id);
        modelAndView.addObject("product",product);
        return modelAndView;
    }
    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.updateProduct(product);
        redirectAttributes.addFlashAttribute("msg","Update successfully!");
        return "redirect:/product/list";
    }
}
