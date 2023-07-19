package com.example.exercise_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class CalculatorController {
    @GetMapping
    public String showCalculatorForm(){
        return "home";
    }
    @PostMapping("/calculator")
    public String calculate(@RequestParam double firstNumber, @RequestParam double secondNumber,
                            @RequestParam String operator, RequestAttribute requestAttribute){

        return "redirect:"
    }
}
