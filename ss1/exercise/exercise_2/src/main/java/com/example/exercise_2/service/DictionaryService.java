package com.example.exercise_2.service;

import com.example.exercise_2.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;
    @Override
    public String findVocabulary(String search) {
        return dictionaryRepository.findVocabulary(search);
    }
}
