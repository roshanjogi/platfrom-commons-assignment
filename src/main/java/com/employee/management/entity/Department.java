package com.employee.management.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    private String name;
    private String description;
    private String type;
    private int numberOfEmployees;

    @ManyToMany(mappedBy = "departments")
    private List<Employee> employees = new ArrayList<>();

    private List<String> projects = new ArrayList<>();

    public Department() {
    }
    public Department(String name, String description, String type, int numberOfEmployees, List<Employee> employees, List<String> projects) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.numberOfEmployees = numberOfEmployees;
        this.employees = employees;
        this.projects = projects;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    public List<String> getProjects() {
        return projects;
    }
    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}
