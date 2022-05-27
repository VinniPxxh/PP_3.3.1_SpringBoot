package com.preproject.spring.springboot.service;

import com.preproject.spring.springboot.Repository.UserRepository;
import com.preproject.spring.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addOrUpdateUser(User user) {
        return userRepository.save(user);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
