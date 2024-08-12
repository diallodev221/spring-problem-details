package com.diallodev.springproblemdetails.customer.exception;


public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Integer customerId) {
        super(String.format("Customer with ID: %s not found", customerId));
    }
}
