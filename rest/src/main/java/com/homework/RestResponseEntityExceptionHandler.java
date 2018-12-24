package com.homework;

import com.homework.exception.LoanApplicationValidationException;
import com.homework.exception.LoanNotExistException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {RuntimeException.class})
    protected ResponseEntity<Object> handleRuntimeException(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Something wrong";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value
            = {LoanNotExistException.class})
    protected ResponseEntity<Object> handleLoanNotExistException(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Loan dose not exist";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value
            = {LoanApplicationValidationException.class})
    protected ResponseEntity<Object> handleLoanApplicationValidationException(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Wrong loan application";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
