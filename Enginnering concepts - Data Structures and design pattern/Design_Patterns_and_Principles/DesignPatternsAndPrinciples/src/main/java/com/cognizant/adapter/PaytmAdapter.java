package com.cognizant.adapter;

public class PaytmAdapter implements PaymentProcessor {

    private final PaytmGateway paytmGateway;

    public PaytmAdapter(PaytmGateway paytmGateway) {
        this.paytmGateway = paytmGateway;
    }

    @Override
    public void processPayment(double amount) {
        paytmGateway.makePayment(amount);
    }
}