package com.example.exercise_1.service;

import com.example.exercise_1.model.Book;
import com.example.exercise_1.model.Borrow;
import com.example.exercise_1.model.LibraryCard;
import com.example.exercise_1.repository.IBookRepository;
import com.example.exercise_1.repository.IBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private IBorrowRepository borrowRepository;
    @Autowired
    private IBookService bookService;

    @Override
    public Boolean save(Book book, LibraryCard libraryCard, String generatedString) {
        Boolean check = bookService.checkQuantity(book);
        if(!check){
            return false;
        }
        bookService.decreaseByOneBook(book);
        Borrow borrow = new Borrow();
        borrow.setBook(book);
        borrow.setLibraryCard(libraryCard);
        borrow.setCode(generatedString);
        borrowRepository.save(borrow);
        return true;
    }

    @Override
    public Boolean deleteBorrowByCode(String code) {
        Borrow borrow = borrowRepository.findBorrowByCode(code);
        if(borrow == null){
            return false;
        }
        bookService.increaseByOneBook(code);
        borrowRepository.deleteBorrowByCode(code);
        return true;
    }

}
