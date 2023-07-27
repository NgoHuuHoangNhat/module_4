package com.example.exercise_1a.service;

import com.example.exercise_1a.model.User;
import com.example.exercise_1a.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
}
