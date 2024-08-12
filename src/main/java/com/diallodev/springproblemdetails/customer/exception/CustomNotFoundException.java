package com.diallodev.springproblemdetails.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;
import java.time.Instant;

// custom exceptions, we can extend from ErrorResponseException and just throw the Exception.
public class CustomNotFoundException extends ErrorResponseException {
    public CustomNotFoundException(Integer customerId) {
        super(HttpStatus.BAD_REQUEST, asProblemDetail(String.format("Customer with ID: %d not found",customerId )), null);
    }

    public static ProblemDetail asProblemDetail(String message) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, message);
        problemDetail.setTitle("Customer Not Found");
        problemDetail.setType(URI.create("https://api.bookmarks.com/errors/not-found"));
        problemDetail.setProperty("errorCategory", "Generic");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
