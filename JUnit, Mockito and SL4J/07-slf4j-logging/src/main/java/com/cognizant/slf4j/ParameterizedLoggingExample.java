package com.cognizant.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {

        String username = "Krishna";
        int age = 22;
        double salary = 75000.50;

        logger.info("User Name: {}", username);

        logger.info("Age: {}", age);

        logger.info("Salary: {}", salary);

        logger.info(
                "Employee Details -> Name: {}, Age: {}, Salary: {}",
                username,
                age,
                salary
        );
    }
}