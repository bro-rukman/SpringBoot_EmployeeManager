package com.example.crud_api.error;

import lombok.Data;

import java.util.List;
@Data
public class ErrorEmptyEntity {
    private List<ErrorDetails> errors;
    @Data
    public static class ErrorDetails{
        private String fieldName;
        private String message;
    }
}
