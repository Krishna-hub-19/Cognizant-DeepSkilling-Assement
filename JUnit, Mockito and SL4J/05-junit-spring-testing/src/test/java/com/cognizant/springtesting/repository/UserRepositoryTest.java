package com.cognizant.springtesting.repository;

import com.cognizant.springtesting.entity.User;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByName() {

        // Arrange
        userRepository.save(new User(1L, "Krishna"));
        userRepository.save(new User(2L, "Rahul"));

        // Act
        List<User> users = userRepository.findByName("Krishna");

        // Assert
        assertEquals(1, users.size());
        assertEquals("Krishna", users.get(0).getName());

    }
}