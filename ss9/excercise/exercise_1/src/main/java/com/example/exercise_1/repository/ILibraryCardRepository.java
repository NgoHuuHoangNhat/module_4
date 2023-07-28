package com.example.exercise_1.repository;

import com.example.exercise_1.model.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibraryCardRepository extends JpaRepository<LibraryCard,Integer> {
    LibraryCard findByCode(String cardCode);
}
