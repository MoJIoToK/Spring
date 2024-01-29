package com.example.l4.service;

import com.example.l4.model.User;
import com.example.l4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        userRepository.save(new User(null, "Nick", "1@mail.ru"));
        userRepository.save(new User(null, "John", "2@mail.ru"));
        userRepository.save(new User(null, "Kate", "3@mail.ru"));
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id);
    }
}
