package com.homeloan.homeloan.exception;

import java.io.Serial;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdNotFoundException extends HomeLoanBaseException {
    @Serial
    private static final long serialVersionUID = 4365584630169346927L;

    IdNotFoundException() {
    }

    public IdNotFoundException(String message) {
        super(message);
    }
}
