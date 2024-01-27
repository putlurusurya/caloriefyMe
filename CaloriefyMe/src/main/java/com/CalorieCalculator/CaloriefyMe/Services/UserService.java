package com.CalorieCalculator.CaloriefyMe.Services;

import org.springframework.stereotype.Service;

import com.CalorieCalculator.CaloriefyMe.Models.User;
import com.CalorieCalculator.CaloriefyMe.Repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(User user) {
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }
}
