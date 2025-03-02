package com.homeloan.homeloan.exception;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@Builder
public class HomeLoanError {
    private int errorCode;
    private List<String> errorMessage;
    private String description;
}
