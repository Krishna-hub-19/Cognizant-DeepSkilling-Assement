package com.cognizant.springtesting.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void testAdd() {
        assertEquals(30, calculatorService.add(10, 20));
    }

    @Test
    void testAddNegativeNumbers() {
        assertEquals(-15, calculatorService.add(-5, -10));
    }

    @Test
    void testAddZero() {
        assertEquals(10, calculatorService.add(0, 10));
    }

    @Test
    void testAddPositiveAndNegative() {
        assertEquals(5, calculatorService.add(10, -5));
    }

    @Test
    void testAddLargeNumbers() {
        assertEquals(3000000, calculatorService.add(1000000, 2000000));
    }
}