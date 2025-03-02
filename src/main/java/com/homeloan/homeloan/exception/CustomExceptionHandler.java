package com.homeloan.homeloan.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    /*@ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IdNotFoundException.class)
    public ErrorEvent handleInvalidInputParameterException(IdNotFoundException ex){
        return ErrorEvent.builder()
                .id("")
                .code(HttpStatusCode.valueOf(400))
                .description(ex.getMessage())
                .created("")
                .build();

    }*/
    private HomeLoanError getHomeLoanError(List<String> errorMessage, int errorCodeEnum) {
        return HomeLoanError.builder()
                .errorCode(errorCodeEnum)
                .errorMessage(errorMessage)
                .build();
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        HomeLoanError response = getHomeLoanError(ErrorCodeEnum.ENTITY_NOT_FOUND.getMessages(), ErrorCodeEnum.ENTITY_NOT_FOUND.getCode());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
    public ResponseEntity<Object> handleInvalidDataAccess(InvalidDataAccessResourceUsageException ex) {
        HomeLoanError response = getHomeLoanError(ErrorCodeEnum.ENTITY_NOT_FOUND.getMessages(), ErrorCodeEnum.ENTITY_NOT_FOUND.getCode());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequest(BadRequestException ex) {
        return new ResponseEntity<>("Bad Request: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
