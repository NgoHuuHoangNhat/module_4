package com.example.exercise_1.service;

import com.example.exercise_1.model.LibraryCard;
import com.example.exercise_1.repository.ILibraryCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryCardService implements ILibraryCardService{
    @Autowired
    private ILibraryCardRepository libraryCardRepository;
    @Override
    public LibraryCard findByCardCode(String cardCode) {
        return libraryCardRepository.findByCode(cardCode);
    }
}
