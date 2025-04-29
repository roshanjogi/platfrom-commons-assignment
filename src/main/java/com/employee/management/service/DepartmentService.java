package com.employee.management.service;

import com.employee.management.entity.Department;
import com.employee.management.entity.Employee;
import com.employee.management.exception.DepartmentAlreadyExistsException;
import com.employee.management.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department department) {
        if(departmentRepository.existsById(department.getName())) {
            throw new DepartmentAlreadyExistsException(department.getName());
        }
        return departmentRepository.save(department);
    }

}
