package com.example.exercise_1.repository;

import com.example.exercise_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<User, Integer> {
}
