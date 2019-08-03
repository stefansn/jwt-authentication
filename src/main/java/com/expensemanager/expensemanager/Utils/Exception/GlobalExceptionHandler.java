package com.expensemanager.expensemanager.Utils.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException e, WebRequest request){
        ErrorDetails errorDetails =
                new ErrorDetails(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> globalExceptionHandler(Exception e, WebRequest request){
        ErrorDetails errorDetails =
                new ErrorDetails(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
