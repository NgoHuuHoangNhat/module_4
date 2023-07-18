package com.example.exercise_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @GetMapping
    public String searchDictionaryForm(){
        return "dictionary";
    }
    @GetMapping("dictionary")
    public String searchDictionary(@RequestParam String search, Model model){
        String[] vietnameseArr = {"Xe hơi","Nhà","Bút","Sách"};
        String[] englishArr = {"Car","House","Pen","Bool"};
        if(search == null || search.equals("")){
            model.addAttribute("result","Please enter something!");
        }else {
            String result = null;
            for (int i = 0; i < vietnameseArr.length; i++) {
                if(vietnameseArr[i].toLowerCase().equals(search.toLowerCase())){
                    result = englishArr[i];
                }
            }
            if(result == null){
                model.addAttribute("result","The word "+search+" could not be found in the dictionary!");
            }else {
                model.addAttribute("result","The word "+search+" translates into English as "+result+".");
            }
        }
        return "dictionary";
    }
}
