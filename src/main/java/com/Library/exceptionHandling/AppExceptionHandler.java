package com.Library.exceptionHandling;

import com.Library.common.ApiResponse;
import com.Library.exceptions.BookNotFoundException;
import com.Library.exceptions.PatronNotFoundException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

@Slf4j
@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler({BookNotFoundException.class, PatronNotFoundException.class})
    public ResponseEntity<ApiResponse> handelRunTimeException(BookNotFoundException ex) {

        ApiResponse er = ApiResponse.of(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiResponse> handelNPException(NullPointerException ex) {

        ApiResponse er = ApiResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(BindException.class)
    public ResponseEntity<ApiResponse> handleRuntimeException(BindException ex) {

        log.info("Came Here :D");
        ApiResponse er = ApiResponse.of(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> handleRuntimeException(IllegalArgumentException ex) {

        log.info("Came Here :D");
        ApiResponse er = ApiResponse.of(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }
}

