package com.cognizant.observer;

public class WebApp implements Observer {

    @Override
    public void update(String stockName, double stockPrice) {

        System.out.println(
                "Web App: " +
                        stockName +
                        " updated to " +
                        stockPrice);

    }

}