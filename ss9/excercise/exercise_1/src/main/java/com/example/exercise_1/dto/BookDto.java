package com.example.exercise_1.dto;

import com.example.exercise_1.model.Borrow;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;

public class BookDto implements Validator {
    private Integer id;
    private String name;
    private String content;
    private String author;
    private Long quantity;
    private Set<Borrow> borrowSet;

    public BookDto() {
    }

    public BookDto(Integer id, String name, String content, String author, Long quantity, Set<Borrow> borrowSet) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.author = author;
        this.quantity = quantity;
        this.borrowSet = borrowSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Set<Borrow> getBorrowSet() {
        return borrowSet;
    }

    public void setBorrowSet(Set<Borrow> borrowSet) {
        this.borrowSet = borrowSet;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
