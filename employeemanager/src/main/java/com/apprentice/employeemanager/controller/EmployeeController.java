package com.apprentice.employeemanager.controller;

import com.apprentice.employeemanager.model.Employee;
import com.apprentice.employeemanager.service.EmployeeService;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> getEmployees(){
        List<Employee> employees = getEmployees();
        return employees;
    }

    @GetMapping("/search{id}")
    public Employee searchEmployeeById(@PathVariable("id") Long id) throws NotFoundException {
            Employee employee = employeeService.findEmployeeById(id);
        return employee;
    }

    @PostMapping("/new")
    public void newEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

}
