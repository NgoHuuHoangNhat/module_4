package com.example.exercise_1.controller;

import com.example.exercise_1.model.EmailBox;
import com.example.exercise_1.model.Language;
import com.example.exercise_1.model.PageSize;
import com.example.exercise_1.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/box")
public class EmailBoxController {
    @Autowired
    private IEmailBoxService emailBoxService;
    @ModelAttribute("language")
    public List<Language> getLanguageList(){
        return emailBoxService.findAllLanguageList();
    }
    @ModelAttribute("pageSize")
    public List<PageSize> getPageSizeList(){
        return emailBoxService.findAllPageSizeList();
    }
    @GetMapping("/update")
    public ModelAndView showUpdateForm(){
        ModelAndView modelAndView = new ModelAndView("update");
        EmailBox emailBox = emailBoxService.findEmailBox();
        modelAndView.addObject("emailBox",emailBox);
        return modelAndView;
    }
    @PostMapping("/success")
    public ModelAndView updateEmailBox(@ModelAttribute EmailBox emailBox){
        System.out.println(123);
        ModelAndView modelAndView = new ModelAndView("success");
        emailBoxService.updateEmailBox(emailBox);
        modelAndView.addObject("emailBox",emailBox);
        return modelAndView;
    }

}
