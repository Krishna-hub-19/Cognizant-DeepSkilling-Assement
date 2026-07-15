package com.cognizant.junitadvanced;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        EvenOddCheckerTest.class,
        CalculatorTest.class
})
public class AllTests {
}