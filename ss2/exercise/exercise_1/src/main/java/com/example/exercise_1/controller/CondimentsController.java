package com.example.exercise_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/condiment")
public class CondimentsController {
    @GetMapping("/list")
    public String showList() {
        return "list";
    }
    @PostMapping("/select")
    public ModelAndView select(@RequestParam(value = "condiment", required = false) String[] condiment){
        ModelAndView modelAndView = new ModelAndView("select");
        if(condiment == null || condiment.length == 0){
            modelAndView.addObject("msg","You have not selected anything,please return!");
        }else {
            List<String> list = Arrays.asList(condiment);
            modelAndView.addObject("list",list);
        }
        return modelAndView;
    }
}
