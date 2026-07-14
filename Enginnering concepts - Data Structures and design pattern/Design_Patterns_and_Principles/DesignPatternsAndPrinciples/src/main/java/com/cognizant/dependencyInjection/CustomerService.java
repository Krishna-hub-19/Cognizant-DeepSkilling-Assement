package com.cognizant.dependencyInjection;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomer(int customerId) {

        String customer =
                customerRepository.findCustomerById(customerId);

        System.out.println(customer);

    }

}