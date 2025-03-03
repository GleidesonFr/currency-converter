package com.spring.currency_converter.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.currency_converter.exceptions.APIError;

@RestControllerAdvice
public class RestExceptionHandlerController {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIError> genericException(Exception exception){
        APIError apiError = APIError.builder().timestamp(LocalDateTime.now()).code(HttpStatus.INTERNAL_SERVER_ERROR.value()).status(HttpStatus.INTERNAL_SERVER_ERROR.name()).errors(List.of(exception.getMessage())).build();
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIError> argumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        List<String> errorList = methodArgumentNotValidException.getBindingResult().getFieldErrors().stream().map(error -> error.getField() + ":" + error.getDefaultMessage()).collect(Collectors.toList());
        APIError apiError = APIError.builder().timestamp(LocalDateTime.now()).code(HttpStatus.BAD_REQUEST.value()).status(HttpStatus.BAD_REQUEST.name()).errors(errorList).build();
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
