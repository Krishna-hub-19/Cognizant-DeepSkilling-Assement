package com.cognizant.junitadvanced;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void initializeDatabase() {
        System.out.println("Step 1: Initialize Database");
    }

    @Test
    @Order(2)
    void loadTestData() {
        System.out.println("Step 2: Load Test Data");
    }

    @Test
    @Order(3)
    void executeBusinessLogic() {
        System.out.println("Step 3: Execute Business Logic");
    }

    @Test
    @Order(4)
    void cleanupResources() {
        System.out.println("Step 4: Cleanup Resources");
    }
}