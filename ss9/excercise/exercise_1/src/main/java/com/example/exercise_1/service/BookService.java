package com.example.exercise_1.service;

import com.example.exercise_1.model.Book;
import com.example.exercise_1.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void decreaseByOneBook(Book book) {
        book.setQuantity(book.getQuantity()-1);
        bookRepository.save(book);
    }
    @Override
    public void increaseByOneBook(String code) {
        Book book = bookRepository.findBookBorrowByCode(code);
        book.setQuantity(book.getQuantity()+1);
        bookRepository.save(book);
    }

    @Override
    public Book findBookBorrowByCode(String code) {
        return bookRepository.findBookBorrowByCode(code);
    }

    @Override
    public Boolean checkQuantity(Book book) {
        Long quantity = bookRepository.getQuantity(book.getId());
        if(quantity == null || quantity <= 0){
            return false;
        }
        return true;
    }


}
