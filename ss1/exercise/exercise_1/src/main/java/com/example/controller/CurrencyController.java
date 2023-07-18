package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping
    public String currencyConversionForm() {
        return "/currency";
    }

    @GetMapping("currency")
    public String currencyConversion(@RequestParam double usd, @RequestParam float rate, Model model) {
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        if (usd <= 0 || rate <= 0) {
            model.addAttribute("result", "Input number must be greater than 0!");
            return "/currency";
        }
        double result = usd * rate;
        model.addAttribute("result", result);
        model.addAttribute("vnd", "VND:");
        return "/currency";
    }
}
