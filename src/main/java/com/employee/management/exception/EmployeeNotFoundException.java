package com.employee.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
    private long Id;
    public EmployeeNotFoundException(long id){
        super(String.format("Employee is not found with employee code : '%s'",id));
        this.Id = id;
    }
}
