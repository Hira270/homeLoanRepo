package com.homeloan.homeloan.exception;

import java.io.Serial;

public class HomeLoanOfferNotFoundException extends HomeLoanBaseException {
    @Serial
    private static final long serialVersionUID = 4365584630169346927L;

    HomeLoanOfferNotFoundException() {
    }

    public HomeLoanOfferNotFoundException(String message) {
        super(message);
    }
}
