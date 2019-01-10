package com.acl.management.acl.controller;

import com.acl.management.acl.exception.AclException;
import com.acl.management.acl.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiError> handleAccessDeniedAcception(AccessDeniedException ex, WebRequest req){
        ApiError error = new ApiError(HttpStatus.FORBIDDEN.toString(),
                                ex.getMessage(), new Date());
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(Exception ex, WebRequest req){
        ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                ex.getMessage(), new Date());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AclException.class)
    public ResponseEntity<ApiError> handleApplicationException(AclException ex, WebRequest req){
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST.toString(),
                ex.getMessage(), new Date());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
