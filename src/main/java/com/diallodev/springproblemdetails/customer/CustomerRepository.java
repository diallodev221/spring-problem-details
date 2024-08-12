package com.diallodev.springproblemdetails.customer;

import org.springframework.data.repository.CrudRepository;

interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
