package com.cognizant.junitadvanced;

public class PerformanceTester {

    public void performTask() {

        try {
            // Simulate some work
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}