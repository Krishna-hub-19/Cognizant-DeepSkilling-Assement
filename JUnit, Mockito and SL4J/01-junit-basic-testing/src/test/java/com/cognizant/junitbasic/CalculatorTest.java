package com.cognizant.junitbasic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(10, calculator.add(5,5));
    }

    @Test
    public void testSubtraction() {
        assertEquals(2, calculator.subtract(5,3));
    }

    @Test
    public void testMultiplication() {
        assertEquals(15, calculator.multiply(3,5));
    }

    @Test
    public void testDivision() {
        assertEquals(2, calculator.divide(10,5));
    }

}