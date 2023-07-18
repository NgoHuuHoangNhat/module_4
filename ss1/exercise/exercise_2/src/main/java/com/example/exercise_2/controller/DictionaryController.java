package com.example.exercise_2.controller;

import com.example.exercise_2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;
    @GetMapping
    public String searchDictionaryForm(){
        return "dictionary";
    }
    @GetMapping("dictionary")
    public String searchDictionary(@RequestParam String search, Model model){
        if(search == null || search.trim().equals("")){
            model.addAttribute("result","Please enter something!");
        }else {
            String result = dictionaryService.findVocabulary(search);
            if(result == null){
                model.addAttribute("result","The word \""+search+"\" could not be found in the dictionary!");
            }else {
                model.addAttribute("result","The word \""+search+"\" translates into English as \""+result+"\".");
            }
        }
        model.addAttribute("search",search);
        return "dictionary";
    }
}
