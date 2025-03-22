package com.homeloan.homeloan.exception;

import com.homeloan.homeloan.domain.LoanApplicationReqResponse;
import io.jsonwebtoken.JwtException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.management.JMException;
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

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input:"+ex.getMessage());
    }
    @ExceptionHandler(JwtException.class)
    public ResponseEntity<String> handleJwtException(JwtException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT error:"+ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred:"+ex.getMessage());
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<String> handleIdNotFoundException(IdNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input:"+ex.getMessage());
    }

    @ExceptionHandler(HomeLoanOfferNotFoundException.class)
    public ResponseEntity<String> handleHomeLoanOfferNotFoundException(HomeLoanOfferNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input:"+ex.getMessage());
    }
    @ExceptionHandler(LoanRequestException.class)
    public ResponseEntity<String> handleLoanRequestException(LoanRequestException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(LoanRequestNotFoundException.class)
    public ResponseEntity<String> handleLoanRequestNotFoundException(LoanRequestNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<String> handleUnauthorizedAccessException(UnauthorizedAccessException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(InvalidStatusException.class)
    public ResponseEntity<String> handleInvalidStatusException(InvalidStatusException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
