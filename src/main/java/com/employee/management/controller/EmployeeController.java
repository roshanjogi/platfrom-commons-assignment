package com.employee.management.controller;

import com.employee.management.dto.EmployeeDTO;
import com.employee.management.dto.mapper.EmployeeMapper;
import com.employee.management.exception.InvalidCredentialsException;
import com.employee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public String employeeLogin(@RequestParam Long employeeCode,
                                @RequestParam String dateOfBirth) {
        LocalDate dob = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        boolean isValid = employeeService.validateEmployee(employeeCode, dob);
        if (isValid) {
            return "Employee authenticated successfully!";
        } else {
            throw new InvalidCredentialsException();
        }
    }

    @PutMapping("/{employeeCode}/profile")
    public ResponseEntity<EmployeeDTO> updateProfile(
            @PathVariable Long employeeCode,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String mobileNumber,
            @RequestParam(required = false) String emergencyContact) {

        EmployeeDTO updaedEmployee = EmployeeMapper.toDTO(employeeService.updateProfile(employeeCode, email, mobileNumber, emergencyContact));
        return new ResponseEntity<>(updaedEmployee, HttpStatus.OK);
    }

    @GetMapping("/{employeeCode}/departments")
    public List<String> getAssignedDepartments(@PathVariable Long employeeCode) {
        return employeeService.getAssignedDepartments(employeeCode);
    }


}
