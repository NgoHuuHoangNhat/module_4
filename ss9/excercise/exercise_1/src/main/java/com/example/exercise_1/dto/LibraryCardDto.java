package com.example.exercise_1.dto;

import com.example.exercise_1.model.Borrow;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.OneToMany;
import java.util.Set;

public class LibraryCardDto implements Validator {
    private Integer id;
    private String code;
    private String userName;
    private Set<Borrow> borrowSet;

    public LibraryCardDto() {
    }

    public LibraryCardDto(Integer id, String code, String userName, Set<Borrow> borrowSet) {
        this.id = id;
        this.code = code;
        this.userName = userName;
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
