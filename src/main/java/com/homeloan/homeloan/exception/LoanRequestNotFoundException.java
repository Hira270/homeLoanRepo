package com.homeloan.homeloan.exception;

import java.io.Serial;

public class LoanRequestNotFoundException extends HomeLoanBaseException {
    @Serial
    private static final long serialVersionUID = 4365584630169346927L;

    LoanRequestNotFoundException() {
    }

    public LoanRequestNotFoundException(String message) {
        super(message);
    }
}
