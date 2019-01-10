package com.acl.management.acl.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ApiError {
    private String status;
    private String message;
    private Date timestamp;

    public ApiError(String status, String message, Date timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}
