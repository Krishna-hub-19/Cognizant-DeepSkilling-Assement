package com.cognizant.springtesting;

import com.cognizant.springtesting.entity.User;
import com.cognizant.springtesting.repository.UserRepository;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveAndFetchUser() {

        // Arrange
        User user = new User(1L, "Krishna");

        // Act
        userRepository.save(user);

        User savedUser = userRepository.findById(1L).orElse(null);

        // Assert
        assertNotNull(savedUser);
        assertEquals("Krishna", savedUser.getName());

    }

}