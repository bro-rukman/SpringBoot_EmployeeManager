package com.example.crud_api.exceptions;

public class VegetableNotFound extends RuntimeException{
    public VegetableNotFound(String message){
        super(message);
    }
}
