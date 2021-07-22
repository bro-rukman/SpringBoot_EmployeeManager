package com.example.crud_api.exceptions;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message){
        super(message);
    }
}
