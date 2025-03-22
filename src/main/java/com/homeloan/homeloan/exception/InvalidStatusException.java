package com.homeloan.homeloan.exception;

import java.io.Serial;

public class InvalidStatusException extends HomeLoanBaseException {
    @Serial
    private static final long serialVersionUID = 4365584630169346927L;

    InvalidStatusException() {
    }

    public InvalidStatusException(String message) {
        super(message);
    }
}
