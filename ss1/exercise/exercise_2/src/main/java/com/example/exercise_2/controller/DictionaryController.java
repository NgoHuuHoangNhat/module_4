package com.example.exercise_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    private static Map<String,String> dictionary = new HashMap<>();
    static {
        dictionary.put("xe hơi","car");
        dictionary.put("nhà","house");
        dictionary.put("bút","pen");
        dictionary.put("sách","book");
    }
    @GetMapping
    public String searchDictionaryForm(){
        return "dictionary";
    }
    @GetMapping("dictionary")
    public String searchDictionary(@RequestParam String search, Model model){

        if(search == null || search.equals("")){
            model.addAttribute("result","Please enter something!");
        }else {
            String result = null;
            if(dictionary.containsKey(search.trim().toLowerCase())){
                result = dictionary.get(search.trim().toLowerCase());
            }
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
