package com.example.exercise_1.service;

import com.example.exercise_1.model.Book;
import com.example.exercise_1.model.LibraryCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    Book findById(Integer id);


    void decreaseByOneBook(Book book);

    Boolean checkQuantity(Book book);

    void increaseByOneBook(String code);
    Book findBookBorrowByCode(String code);
}
