package com.employee.management.dto.mapper;

import com.employee.management.dto.DepartmentDTO;
import com.employee.management.entity.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentMapper {

    public static List<DepartmentDTO> toDtoList(List<Department> departments) {
        if (departments == null) {
            return null;
        }
        List<DepartmentDTO> dtos = new ArrayList<>();
        for (Department department : departments) {
            dtos.add(toDTO(department));
        }
        return dtos;
    }

    public static DepartmentDTO toDTO(Department department) {
        if (department == null) {
            return null;
        }
        DepartmentDTO dto = new DepartmentDTO();
        dto.setDepartmentName(department.getName());
        dto.setDescription(department.getDescription());
        dto.setType(department.getType());
        dto.setNumberOfEmployees(department.getNumberOfEmployees());
        dto.setProjects(department.getProjects());
        return dto;
    }

    public static List<Department> toEntityList(List<DepartmentDTO> dtos) {
        if (dtos == null) {
            return null;
        }
        List<Department> departments = new ArrayList<>();
        for (DepartmentDTO dto : dtos) {
            departments.add(toEntity(dto));
        }
        return departments;
    }

    public static Department toEntity(DepartmentDTO dto) {
        if (dto == null) {
            return null;
        }
        Department department = new Department();
        department.setName(dto.getDepartmentName());
        department.setDescription(dto.getDescription());
        department.setType(dto.getType());
        department.setNumberOfEmployees(dto.getNumberOfEmployees());
        department.setProjects(dto.getProjects());
        return department;
    }
}
