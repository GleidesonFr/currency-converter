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
import com.spring.currency_converter.exceptions.EmailAlreadyExistsException;
import com.spring.currency_converter.exceptions.EmailNotValidException;
import com.spring.currency_converter.exceptions.UserAlreadyExistsException;
import com.spring.currency_converter.exceptions.UserNotFoundException;

@RestControllerAdvice
public class RestExceptionHandlerController {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIError> genericException(Exception exception){
        APIError apiError = APIError.builder().timestamp(LocalDateTime.now()).code(HttpStatus.INTERNAL_SERVER_ERROR.value()).status(HttpStatus.INTERNAL_SERVER_ERROR.name()).errors(List.of(exception.getMessage())).build();
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<APIError> notFoundException(RuntimeException runtimeException){
        APIError apiError = APIError.builder().timestamp(LocalDateTime.now()).code(HttpStatus.NOT_FOUND.value()).status(HttpStatus.NOT_FOUND.name()).errors(List.of(runtimeException.getMessage())).build();
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailNotValidException.class)
    public ResponseEntity<APIError> emailNotValidException(RuntimeException runtimeException){
        APIError apiError = APIError.builder().timestamp(LocalDateTime.now()).code(HttpStatus.BAD_REQUEST.value()).status(HttpStatus.BAD_REQUEST.name()).errors(List.of(runtimeException.getMessage())).build();
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
        EmailAlreadyExistsException.class,
        UserAlreadyExistsException.class
    })
    public ResponseEntity<APIError> alreadyExistsException(RuntimeException runtimeException){
        APIError apiError = APIError.builder().timestamp(LocalDateTime.now()).code(HttpStatus.CONFLICT.value()).status(HttpStatus.CONFLICT.name()).errors(List.of(runtimeException.getMessage())).build();
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIError> argumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        List<String> errorList = methodArgumentNotValidException.getBindingResult().getFieldErrors().stream().map(error -> error.getField() + ":" + error.getDefaultMessage()).collect(Collectors.toList());
        APIError apiError = APIError.builder().timestamp(LocalDateTime.now()).code(HttpStatus.BAD_REQUEST.value()).status(HttpStatus.BAD_REQUEST.name()).errors(errorList).build();
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
