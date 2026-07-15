package com.cognizant.junitbasic;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssertionsTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAssertions() {

        // assertEquals
        assertEquals(5, calculator.add(2, 3));

        // assertTrue
        assertTrue(calculator.multiply(2, 5) == 10);

        // assertFalse
        assertFalse(calculator.subtract(5, 3) == 1);

        // assertNull
        String value = null;
        assertNull(value);

        // assertNotNull
        assertNotNull(calculator);
    }
}