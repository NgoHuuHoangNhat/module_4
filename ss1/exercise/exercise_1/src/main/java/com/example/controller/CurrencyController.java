package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping("currency_conversion_form")
    public String currencyConversionForm(){
        return "/currency";
    }
    @GetMapping("currency_conversion/currency")
    public String currencyConversion(@RequestParam double usd, @RequestParam float rate, Model model){
        double result = usd*rate;
        model.addAttribute("result", result);
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        return "/currency";
    }
}
