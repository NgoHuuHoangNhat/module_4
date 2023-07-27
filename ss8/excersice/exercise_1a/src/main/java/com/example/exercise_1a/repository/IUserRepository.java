package com.example.exercise_1a.repository;


import com.example.exercise_1a.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
