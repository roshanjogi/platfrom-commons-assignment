package com.employee.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyExistsException extends RuntimeException{
    private long Id;

    public EmployeeAlreadyExistsException(long id){
        super(String.format("Employee already exists with code : '%s'",id));
        this.Id = id;
    }
}
