package com.example.exercise_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @GetMapping
    public String showCalculatorForm() {
        return "home";
    }

    @PostMapping("/result")
    public ModelAndView calculate(@RequestParam(value = "firstNumber", required = false) String firstNumber,
                                  @RequestParam(value = "secondNumber", required = false) String secondNumber,
                                  @RequestParam(value = "operator", required = false) String operator) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("firstNumber", firstNumber);
        modelAndView.addObject("secondNumber", secondNumber);
        if(firstNumber == null||secondNumber == null){
            modelAndView.addObject("err","Please enter the number!");
            return modelAndView;
        }
        Double firstNum;
        Double secondNum;
        try {
            firstNum = Double.parseDouble(firstNumber);
            secondNum = Double.parseDouble(secondNumber);
        }catch (NumberFormatException n){
            modelAndView.addObject("err","Not input word!");
            return modelAndView;
        }

        Double result = null;
        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "/":
                result = firstNum / secondNum;
                if (result.isNaN() || result.isInfinite()){
                    modelAndView.addObject("err", "Cannot be divided by 0!");
                    return modelAndView;
                }
            break;
        }
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}
