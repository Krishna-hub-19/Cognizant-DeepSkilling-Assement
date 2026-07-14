package com.cognizant.strategy;

public class StrategyPatternTest {

    public static void main(String[] args) {

        PaymentContext paymentContext =
                new PaymentContext(new CreditCardPayment());

        paymentContext.executePayment(2500);

        paymentContext.setPaymentStrategy(new PayPalPayment());

        paymentContext.executePayment(5000);

    }

}