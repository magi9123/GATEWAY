package com.controller;

import com.exception.RecordNotFoundException;
import com.utils.Response;
import com.exception.MissingDataRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String INCORRECT_REQUEST = "INCORRECT_REQUEST";
    public static final String RECORD_NOT_FOUND = "RECORD_NOT_FOUND";
    public static final String EXCEPTION = "EXCEPTION";

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Response> handleRequestException(RecordNotFoundException ex, WebRequest webRequest) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        Response error = new Response(INCORRECT_REQUEST, details);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissingDataRequestException.class)
    public ResponseEntity<Response> handleRecordNotFoundException(MissingDataRequestException ex, WebRequest webRequest) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        Response error = new Response(RECORD_NOT_FOUND, details);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(MissingDataRequestException ex, WebRequest webRequest) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        Response error = new Response(EXCEPTION, details);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
