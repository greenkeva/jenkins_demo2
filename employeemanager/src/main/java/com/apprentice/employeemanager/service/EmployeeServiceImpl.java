package com.apprentice.employeemanager.service;

import com.apprentice.employeemanager.model.Employee;
import javassist.NotFoundException;

import java.util.List;

public interface EmployeeServiceImpl {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Employee findEmployeeById(Long id) throws NotFoundException;
    List<Employee> getAllEmployees();
}
