package com.cognizant.adapter;

public class AdapterPatternTest {

    public static void main(String[] args) {

        PaymentProcessor paytm = new PaytmAdapter(new PaytmGateway());

        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());

        paytm.processPayment(1500);

        paypal.processPayment(2500);
    }

}