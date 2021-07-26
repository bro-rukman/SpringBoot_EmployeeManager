package com.example.crud_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class LayananNotFoundException extends RuntimeException{
    public LayananNotFoundException(String message){
        super(message);
    }
}

