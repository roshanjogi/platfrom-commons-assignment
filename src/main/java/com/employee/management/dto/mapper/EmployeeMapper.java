package com.employee.management.dto.mapper;

import com.employee.management.dto.DepartmentDTO;
import com.employee.management.dto.EmployeeDTO;
import com.employee.management.entity.Department;
import com.employee.management.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {

    public static List<EmployeeDTO> toDtoList(List<Employee> employees){
        if (employees == null) {
            return null;
        }
        List<EmployeeDTO> dtoList = new ArrayList<>();
        for (Employee employee : employees) {
            dtoList.add(toDTO(employee));
        }
        return dtoList;

    }

    public static EmployeeDTO toDTO(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeDTO dto = new EmployeeDTO();
        dto.setName(employee.getName());
        dto.setEmployeeCode(employee.getEmployeeCode());
        dto.setDateOfBirth(employee.getDateOfBirth());
        dto.setGender(employee.getGender());
        dto.setEmail(employee.getEmail());
        dto.setMobileNumber(employee.getMobileNumber());
        dto.setEmergencyContact(employee.getEmergencyContact());
        dto.setDepartments(DepartmentMapper.toDtoList(employee.getDepartments()));
        dto.setAddresses(AddressMapper.toDtoList(employee.getAddresses()));
        return dto;
    }

    public static Employee toEntity(EmployeeDTO dto) {
        if (dto == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setEmployeeCode(dto.getEmployeeCode());
        employee.setDateOfBirth(dto.getDateOfBirth());
        employee.setGender(dto.getGender());
        employee.setEmail(dto.getEmail());
        employee.setMobileNumber(dto.getMobileNumber());
        employee.setEmergencyContact(dto.getEmergencyContact());
        employee.setDepartments(DepartmentMapper.toEntityList(dto.getDepartments()));
        employee.setAddresses(AddressMapper.toEntityList(dto.getAddresses()));
        return employee;
    }
}
