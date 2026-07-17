package com.cognizant.springtesting.service;

import com.cognizant.springtesting.entity.User;
import com.cognizant.springtesting.repository.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.cognizant.springtesting.exception.UserNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {

    @Test
    void testGetUserById() {

        // Arrange
        UserRepository mockRepository = mock(UserRepository.class);

        User user = new User(1L, "Krishna");

        when(mockRepository.findById(1L))
                .thenReturn(Optional.of(user));

        UserService userService = new UserService(mockRepository);

        // Act
        User result = userService.getUserById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Krishna", result.getName());

        verify(mockRepository).findById(1L);
    }


    @Test
    void testGetUserByIdNotFound() {

        UserRepository mockRepository = mock(UserRepository.class);

        when(mockRepository.findById(10L))
                .thenReturn(Optional.empty());

        UserService userService = new UserService(mockRepository);

        UserNotFoundException exception = assertThrows(
                UserNotFoundException.class,
                () -> userService.getUserById(10L)
        );

        assertEquals(
                "User not found with id: 10",
                exception.getMessage()
        );

        verify(mockRepository).findById(10L);
    }

    @Test
    void testGetUserByIdThrowsException() {

        UserRepository mockRepository = mock(UserRepository.class);

        when(mockRepository.findById(100L))
                .thenReturn(Optional.empty());

        UserService userService = new UserService(mockRepository);

        UserNotFoundException exception = assertThrows(
                UserNotFoundException.class,
                () -> userService.getUserById(100L)
        );

        assertEquals(
                "User not found with id: 100",
                exception.getMessage()
        );

        verify(mockRepository).findById(100L);

    }
}