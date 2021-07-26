package com.example.crud_api.exceptions;


public class APIException extends RuntimeException{
    /**
     *
     * @param message
     */
    private static final long serialVersionUID = 1L;
    public APIException(String message) {
        super(message);
    }
}
