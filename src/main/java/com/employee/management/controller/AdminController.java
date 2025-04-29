package com.employee.management.controller;

import com.employee.management.dto.DepartmentDTO;
import com.employee.management.dto.EmployeeDTO;
import com.employee.management.dto.mapper.DepartmentMapper;
import com.employee.management.dto.mapper.EmployeeMapper;
import com.employee.management.entity.Department;
import com.employee.management.entity.Employee;
import com.employee.management.service.DepartmentService;
import com.employee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/welcome")
    public String welcomeAdmin() {
        return "Welcome, Admin!";
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employee) {
            Employee savedEmployee = employeeService.addEmployee(EmployeeMapper.toEntity(employee));
            EmployeeDTO employeeDTO = EmployeeMapper.toDTO(savedEmployee);
            return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }

    @PostMapping("/department")
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO department) {
            Department savedDepartment = departmentService.addDepartment(DepartmentMapper.toEntity(department));
            DepartmentDTO departmentDTO = DepartmentMapper.toDTO(savedDepartment);
            return new ResponseEntity<>(departmentDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{employeeCode}/assign-departments")
    public ResponseEntity<EmployeeDTO> assignDepartmentsToEmployee(
            @PathVariable Long employeeCode,
            @RequestBody List<String> departmentNames) {

        Employee updatedEmployee = employeeService.assignDepartmentsToEmployee(employeeCode, departmentNames);
        EmployeeDTO employeeDTO = EmployeeMapper.toDTO(updatedEmployee);
        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<List<EmployeeDTO>> getEmployeeByName(@RequestParam String name) {
        List<EmployeeDTO> employees = EmployeeMapper.toDtoList(employeeService.getEmployeesByName(name));
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/search-by-department-name/{departmentName}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByDepartmentName(@PathVariable String departmentName) {
        List<EmployeeDTO> employees = EmployeeMapper.toDtoList(employeeService.getEmployeesByDepartmentName(departmentName));
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}
