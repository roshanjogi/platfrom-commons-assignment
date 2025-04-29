package com.employee.management.service;

import com.employee.management.entity.Department;
import com.employee.management.entity.Employee;
import com.employee.management.exception.DepartmentNotFoundException;
import com.employee.management.exception.EmployeeAlreadyExistsException;
import com.employee.management.exception.EmployeeNotFoundException;
import com.employee.management.repository.DepartmentRepository;
import com.employee.management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public boolean validateEmployee(Long employeeCode, LocalDate dateOfBirth) {
        return employeeRepository.findByEmployeeCodeAndDateOfBirth(employeeCode, dateOfBirth) != null;
    }

    public Employee addEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getEmployeeCode())) {
            throw new EmployeeAlreadyExistsException(employee.getEmployeeCode());
        }
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    public Employee assignDepartmentsToEmployee(Long employeeCode, List<String> departmentNames) {
        Employee employee = employeeRepository.findById(employeeCode)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeCode));

        for (String departmentName : departmentNames) {
            Department department = departmentRepository.findById(departmentName)
                    .orElseThrow(() -> new DepartmentNotFoundException("Department not found with name: " + departmentName));

            if (!employee.getDepartments().contains(department)) {
                employee.getDepartments().add(department);
                department.getEmployees().add(employee);
            }
        }
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeesByDepartmentName(String departmentName) {
        Department department = departmentRepository.findById(departmentName)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with name: " + departmentName));

        return department.getEmployees();
    }

    public Employee updateProfile(Long employeeCode, String email, String mobileNumber, String emergencyContact) {
        Employee employee = employeeRepository.findById(employeeCode)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeCode));

        if (email != null) employee.setEmail(email);
        if (mobileNumber != null) employee.setMobileNumber(mobileNumber);
        if (emergencyContact != null) employee.setEmergencyContact(emergencyContact);

        return employeeRepository.save(employee);
    }

    public List<String> getAssignedDepartments(Long employeeCode) {
        Employee employee = employeeRepository.findById(employeeCode)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeCode));

        return employee.getDepartments().stream()
                .map(Department::getName)
                .toList();
    }
}
