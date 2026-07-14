package com.cognizant.observer;

public class ObserverPatternTest {

    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        System.out.println("Google Stock Updated");

        stockMarket.setStock("Google", 2500);

        System.out.println();

        System.out.println("Amazon Stock Updated");

        stockMarket.setStock("Amazon", 3450);

    }

}