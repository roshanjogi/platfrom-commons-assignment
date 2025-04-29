package com.employee.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidCredentialsException extends RuntimeException{

    public InvalidCredentialsException(){
        super("Invalid employee code or date of birth!");
    }
}
