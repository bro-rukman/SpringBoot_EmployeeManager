package com.example.crud_api.error;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorDetailEntity {
    private HttpStatus status;
    private String message;
    private Date timestamp;
    private String details;

    public ErrorDetailEntity(){}
    public ErrorDetailEntity(HttpStatus status, String message, Date timestamp, String details) {
        super();
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.details = details;
    }
    public HttpStatus getStatus(){
        return status;
    }
    public void setStatus(HttpStatus status){
        this.status = status;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

