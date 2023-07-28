package com.example.exercise_1.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String userName;
    @OneToMany(mappedBy = "libraryCard")
    private Set<Borrow> borrowSet;

    public LibraryCard() {
    }

    public LibraryCard(Integer id, String code, String userName, Set<Borrow> borrowSet) {
        this.id = id;
        this.code = code;
        this.userName = userName;
        this.borrowSet = borrowSet;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Borrow> getBorrowSet() {
        return borrowSet;
    }

    public void setBorrowSet(Set<Borrow> borrowSet) {
        this.borrowSet = borrowSet;
    }
}
