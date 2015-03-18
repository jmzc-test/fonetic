package com.jmzc.fonetic;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jmzc.fonetic.exception.DBException;

@ControllerAdvice
class GlobalControllerExceptionHandler 
{
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // 500
    @ExceptionHandler(DBException.class)
    public void handle500() {}
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // 400
    @ExceptionHandler(IllegalArgumentException.class)
    public void handle400() {}
}