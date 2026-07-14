package com.cognizant.singleton;

public class SingletonTest {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();

        Logger logger2 = Logger.getInstance();

        logger1.log("Application started.");

        logger2.log("User logged in.");

        System.out.println();

        System.out.println("Logger1 HashCode : " + logger1.hashCode());

        System.out.println("Logger2 HashCode : " + logger2.hashCode());

        System.out.println();

        System.out.println("Same Object : " + (logger1 == logger2));
    }
}