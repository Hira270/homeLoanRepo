package com.homeloan.homeloan.enums;

public enum LoanRequestStatusDetail {
    DRAFT("DRAFT"), SUBMITTED("SUBMITTED"), RESUBMITTED("RESUBMITTED"),
    PENDING("PENDING"), APPROVED("APPROVED"), REJECTED("REJECTED");

    LoanRequestStatusDetail(String name) {
    }

}
