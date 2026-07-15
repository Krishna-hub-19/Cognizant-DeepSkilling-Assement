package com.cognizant.junitadvanced;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EvenOddCheckerTest {

    private final EvenOddChecker evenOddChecker = new EvenOddChecker();

    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,100})
    void testEvenNumbers(int number) {
        assertTrue(evenOddChecker.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,5,7,99})
    void testOddNumbers(int number) {
        assertFalse(evenOddChecker.isEven(number));
    }
}