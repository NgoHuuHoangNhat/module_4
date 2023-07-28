package com.example.exercise_1.service;

import com.example.exercise_1.model.LibraryCard;

public interface ILibraryCardService {
    LibraryCard findByCardCode(String cardCode);
}
