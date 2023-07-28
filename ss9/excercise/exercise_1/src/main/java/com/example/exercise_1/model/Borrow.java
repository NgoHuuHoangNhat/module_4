package com.example.exercise_1.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "code", nullable = false, unique = true)
    private String code;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "library_card_id", referencedColumnName = "id")
    private LibraryCard libraryCard;

    public Borrow(Integer id, String code, Book book, LibraryCard libraryCard) {
        this.id = id;
        this.code = code;
        this.book = book;
        this.libraryCard = libraryCard;
    }

    public Borrow() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LibraryCard getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(LibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }
}
