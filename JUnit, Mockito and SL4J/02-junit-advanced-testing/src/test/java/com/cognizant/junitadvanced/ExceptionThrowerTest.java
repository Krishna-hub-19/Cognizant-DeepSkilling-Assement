package com.cognizant.junitadvanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    private final ExceptionThrower exceptionThrower = new ExceptionThrower();

    @Test
    void testThrowException() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                exceptionThrower::throwException
        );

        assertEquals("Invalid input provided.", exception.getMessage());
    }
}