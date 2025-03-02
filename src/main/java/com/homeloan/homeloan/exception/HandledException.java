package com.homeloan.homeloan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class HandledException {
    @ExceptionHandler
    public ResponseEntity<HomeLoanError> handleException(HomeLoanBaseException ex) {
        HomeLoanError response = getHomeLoanException(ex);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    private HomeLoanError getHomeLoanException(HomeLoanBaseException ex) {

        HomeLoanError response = null;
        if (ex instanceof IdNotFoundException) {
            response = getHomeLoanError(ex.getMessage(), ErrorCodeEnum.ENTITY_NOT_FOUND.getCode());
        } else if (ex instanceof  BadRequestException) {
            response = getHomeLoanError(ex.getMessage(), ErrorCodeEnum.PARAMETER_BAD_REQUEST.getCode());
        }
        return response;
    }

    private HomeLoanError getHomeLoanError(String errorMessage, int errorCodeEnum) {
        return HomeLoanError.builder()
                .errorCode(errorCodeEnum)
                .errorMessage(Collections.singletonList(errorMessage))
                .build();
    }
}
