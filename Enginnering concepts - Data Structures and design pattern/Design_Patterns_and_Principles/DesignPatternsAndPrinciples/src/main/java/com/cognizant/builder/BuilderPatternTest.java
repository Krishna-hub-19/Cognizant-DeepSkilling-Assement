package com.cognizant.builder;

public class BuilderPatternTest {

    public static void main(String[] args) {

        Computer gamingComputer = new Computer.Builder()
                .setCpu("Intel Core i9")
                .setRam("32 GB")
                .setStorage("1 TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11")
                .build();

        gamingComputer.displayConfiguration();

        System.out.println();

        Computer officeComputer = new Computer.Builder()
                .setCpu("Intel Core i5")
                .setRam("16 GB")
                .setStorage("512 GB SSD")
                .setOperatingSystem("Windows 11")
                .build();

        officeComputer.displayConfiguration();
    }
}