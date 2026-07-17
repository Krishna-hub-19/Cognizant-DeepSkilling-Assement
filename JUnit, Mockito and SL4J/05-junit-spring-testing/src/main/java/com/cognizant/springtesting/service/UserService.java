package com.cognizant.springtesting.service;

import com.cognizant.springtesting.entity.User;
import com.cognizant.springtesting.exception.UserNotFoundException;
import com.cognizant.springtesting.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id: " + id));

    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}