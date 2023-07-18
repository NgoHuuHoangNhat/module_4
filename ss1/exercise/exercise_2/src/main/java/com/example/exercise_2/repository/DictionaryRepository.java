package com.example.exercise_2.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class DictionaryRepository implements IDictionaryRepository{
    private static Map<String,String> dictionary = new HashMap<>();
    static {
        dictionary.put("xe hơi","car");
        dictionary.put("nhà","house");
        dictionary.put("bút","pen");
        dictionary.put("sách","book");
    }

    @Override
    public String findVocabulary(String search) {
        String result = null;
        if(dictionary.containsKey(search.trim().toLowerCase())){
            result = dictionary.get(search.trim().toLowerCase());
        }
        return result;
    }
}
