package com.example.exercise_1.cotroller;


import com.example.exercise_1.model.Cart;
import com.example.exercise_1.model.Product;
import com.example.exercise_1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/phone")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error-404";
        }
        cart.addProduct(productOptional.get());
        if (action.equals("show") || (action.equals("detail"))) {
            return "redirect:/shopping-cart";
        }
        return "redirect:/phone/shop";
    }

    @GetMapping("/detail/{id}")
    public String showDetailProduct(@PathVariable Long id, Model model) {
        Product product = productService.findById(id).get();
        model.addAttribute("product", product);

        return "detail";
    }

    @GetMapping("/pay")
    public String payOrder(@ModelAttribute Cart cart, RedirectAttributes redirectAttributes) {
        if(cart.countItemQuantity() == 0){
            redirectAttributes.addFlashAttribute("msg","The cart contains no product!");
            return "redirect:/shopping-cart";
        }
        Float total = cart.countTotalPayment();
        cart.deleteAll();
        redirectAttributes.addFlashAttribute("msg", "You paid with the amount of "+total);
        return "redirect:/phone/shop";
    }
}