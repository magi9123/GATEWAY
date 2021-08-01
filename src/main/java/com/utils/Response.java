package com.utils;

import java.util.List;


public class Response {

    private String message;
    private List<String> details;

    public Response(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }
}
