package com.homeloan.homeloan.exception;

import java.io.Serial;

public class UnauthorizedAccessException extends HomeLoanBaseException {
    @Serial
    private static final long serialVersionUID = 4365584630169346927L;

    UnauthorizedAccessException() {
    }

    public UnauthorizedAccessException(String message) {
        super(message);
    }
}
