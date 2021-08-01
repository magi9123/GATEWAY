package com.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingDataRequestException extends Error {

    public MissingDataRequestException(String message) {
        super(message);
    }
}
