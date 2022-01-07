package com.apprentice.employeemanager.employee;

import com.apprentice.employeemanager.model.Employee;
import com.apprentice.employeemanager.repository.EmployeeRepository;
import com.apprentice.employeemanager.service.EmployeeService;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    private EmployeeService underTest;

    //given
    Employee testEmployee;
    Employee testEmployee2;


    @BeforeEach
    void setUp(){
        underTest = new EmployeeService(employeeRepository);
        testEmployee = new Employee("Kam", "Miller", "kam@mail.com", "manager", "3132001111", 20);
        testEmployee2 = new Employee("Kam", "Miller", "kam@mail.com", "manager", "3132001111", 20);

    }

    @Test
    void canAddEmployee(){

        //when
        underTest.addEmployee(testEmployee);

        //then
        ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);
        verify(employeeRepository).save(employeeArgumentCaptor.capture());
        Employee capturedEmployee = employeeArgumentCaptor.getValue();
        assertThat(capturedEmployee).isEqualTo(testEmployee);
    }

    @Test
    void canUpdateEmployee(){
        //given
        testEmployee.setEmail("km@mail.com");

        //when
        underTest.updateEmployee(testEmployee);

        //then
        ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);
        verify(employeeRepository).save(employeeArgumentCaptor.capture());
        Employee capturedEmployee = employeeArgumentCaptor.getValue();
        assertThat(capturedEmployee).isEqualTo(testEmployee);

    }

    @Test
    void canDeleteEmployee(){
        //when
        doNothing().when(employeeRepository).deleteById(testEmployee.getId());
        underTest.deleteEmployee(testEmployee.getId());

        //then
        verify(employeeRepository, times(1)).deleteById(testEmployee.getId());

    }

    @Test
    void canFindById() throws NotFoundException{
        //given
        Long id = 21L;
        testEmployee.setId(id);

        //when
        when(employeeRepository.findById(id)).thenReturn(Optional.of(testEmployee));
        underTest.findEmployeeById(testEmployee.getId());


        //then
        assertThat(id).isEqualTo(testEmployee.getId());
        verify(employeeRepository, times(1)).findById(testEmployee.getId());


    }

    @Test
    void canGetAllEmployees(){
        //when
        underTest.getAllEmployees();

        //then
        verify(employeeRepository, times(1)).findAll();
    }
}
