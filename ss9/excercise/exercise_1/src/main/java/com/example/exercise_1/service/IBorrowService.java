package com.example.exercise_1.service;

import com.example.exercise_1.model.Book;
import com.example.exercise_1.model.LibraryCard;

public interface IBorrowService {
    Boolean save(Book book, LibraryCard libraryCard, String generatedString);

    Boolean deleteBorrowByCode(String code);
}
