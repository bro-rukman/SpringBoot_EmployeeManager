package com.example.crud_api.advice;
import com.example.crud_api.error.ErrorDetailEntity;
import com.example.crud_api.error.ErrorEmptyEntity;
import com.example.crud_api.exceptions.APIException;
import com.example.crud_api.exceptions.LayananBadRequestException;
import com.example.crud_api.exceptions.LayananNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.*;

@ControllerAdvice
public class GlobalLayananAdvice {
    @ExceptionHandler(LayananNotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(LayananNotFoundException exception, WebRequest webRequest){
        ErrorDetailEntity error = new ErrorDetailEntity(HttpStatus.NOT_FOUND,exception.getMessage(),new Date(),webRequest.getDescription(false));
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setTimestamp(new Date());
        error.setMessage(exception.getMessage());
        error.setDetails(webRequest.getDescription(false));
        return new ResponseEntity(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(APIException.class)
    public ResponseEntity<?> handleGlobalException(APIException exception,WebRequest webRequest){
        ErrorDetailEntity errorDetailEntity = new ErrorDetailEntity(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage(),new Date(),webRequest.getDescription(false));
        errorDetailEntity.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        errorDetailEntity.setTimestamp(new Date());
        errorDetailEntity.setMessage(exception.getMessage());
        errorDetailEntity.setDetails(webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetailEntity,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String,String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->
            errors.put(error.getField(),error.getDefaultMessage()));
        return errors;
    }

}
