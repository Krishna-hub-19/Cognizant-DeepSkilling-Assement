package com.cognizant.dependencyInjection;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public String findCustomerById(int customerId) {

        return "Customer ID: " + customerId + ", Name: Krishna Garg";

    }

}