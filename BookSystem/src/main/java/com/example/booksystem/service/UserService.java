package com.example.booksystem.service;

import com.example.booksystem.model.User;
import com.example.booksystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<User> getUsers() {

        return userRepository.findAll();
    }

    public void addUsers(User user) {

        userRepository.save(user);
    }
}
