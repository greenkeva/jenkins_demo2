package com.apprentice.employeemanager.service;

import com.apprentice.employeemanager.model.Employee;
import com.apprentice.employeemanager.repository.EmployeeRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService implements EmployeeServiceImpl {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) throws NotFoundException {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("ID not found"));
    }

    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
