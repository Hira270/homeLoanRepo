package com.homeloan.homeloan.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class LoanRequestException extends HomeLoanBaseException {
    @Serial
    private static final long serialVersionUID = 4365584630169346927L;

    public LoanRequestException(String message, HttpStatus notFound) {
    }

    public LoanRequestException(String message) {
        super(message);
    }
}
