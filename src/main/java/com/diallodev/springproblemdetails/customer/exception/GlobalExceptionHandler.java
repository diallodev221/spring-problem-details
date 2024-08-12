package com.diallodev.springproblemdetails.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    ProblemDetail handleCustomerNotFoundException(CustomerNotFoundException ex) {
        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Customer Not Found");
        problemDetail.setType(URI.create("http://localhost:8080/errors/not-found"));
        problemDetail.setProperty("errorCategory", "Generic Error");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
