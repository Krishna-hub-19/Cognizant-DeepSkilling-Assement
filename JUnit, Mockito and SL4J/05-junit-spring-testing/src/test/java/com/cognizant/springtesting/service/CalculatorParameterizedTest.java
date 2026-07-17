package com.cognizant.springtesting.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorParameterizedTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @ParameterizedTest
    @CsvSource({
            "2,3,5",
            "10,5,15",
            "-5,5,0",
            "0,0,0",
            "-2,-3,-5"
    })
    void testAdd(int firstNumber,
                 int secondNumber,
                 int expectedResult) {

        int actualResult = calculatorService.add(firstNumber, secondNumber);

        assertEquals(expectedResult, actualResult);

    }
}