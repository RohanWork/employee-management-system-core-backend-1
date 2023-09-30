package com.rohan.employee.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<Object> handleEmployeeException(EmployeeException ex) {
    	Date dte = new Date();
    	DateFormat df = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
    	EmployeeExceptionEntity eee = new EmployeeExceptionEntity(HttpStatus.EXPECTATION_FAILED.value(), ex.getMessage(), df.format(dte));
    	return new ResponseEntity<>(eee, HttpStatus.EXPECTATION_FAILED);
    }
}
