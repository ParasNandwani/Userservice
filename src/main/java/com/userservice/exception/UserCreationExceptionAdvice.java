package com.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserCreationExceptionAdvice {

    @ExceptionHandler(UserCreationException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    String UserCreationExceptionHandler(UserCreationException ex) {
        return ex.getMessage();
    }
}
