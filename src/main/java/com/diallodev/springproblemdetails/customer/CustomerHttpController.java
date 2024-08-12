package com.diallodev.springproblemdetails.customer;

import com.diallodev.springproblemdetails.customer.exception.CustomerNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
class CustomerHttpController {

    private final CustomerRepository customerRepository;

    CustomerHttpController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/{customer-id}")
    Customer getCustomerName(@PathVariable("customer-id") Integer customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

    @GetMapping
    Iterable<Customer> getCustomers() {
        return this.customerRepository.findAll();
    }
}
