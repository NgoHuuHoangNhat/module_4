package com.example.exercise_1a.controller;


import com.example.exercise_1a.dto.UserDto;
import com.example.exercise_1a.model.User;
import com.example.exercise_1a.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/create-form")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("userDto",new UserDto());
        return modelAndView;
    }
    @PostMapping("/create")
    public String createUser(@Valid @ModelAttribute UserDto userDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model){
        System.out.println(userDto.getBirthDay());
        new UserDto().validate(userDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("userDto",userDto);
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.createUser(user);
        redirectAttributes.addFlashAttribute("msg","Create Success!");
        return "redirect:/user/create-form";
    }

}
