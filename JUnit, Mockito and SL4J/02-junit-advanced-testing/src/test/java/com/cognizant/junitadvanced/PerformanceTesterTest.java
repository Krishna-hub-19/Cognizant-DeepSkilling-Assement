package com.cognizant.junitadvanced;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class PerformanceTesterTest {

    private final PerformanceTester performanceTester = new PerformanceTester();

    @Test
    void testPerformance() {

        assertTimeout(Duration.ofSeconds(2), performanceTester::performTask);

    }
}