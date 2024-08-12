package com.diallodev.springproblemdetails.customer;

import org.springframework.data.annotation.Id;

record Customer(@Id Integer id, String name) {
}
