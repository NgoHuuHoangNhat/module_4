package com.example.practice_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private static final String REGEX_EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    @GetMapping
    public String showHome(){
        return "home";
    }
    @PostMapping("validate")
    public String checkEmail(@RequestParam String email, Model model){
        if(!email.matches(REGEX_EMAIL)){
            model.addAttribute("message","This is wrong mail format!");
            return "home";
        }
        model.addAttribute("email",email);
        return "success";
    }

}
