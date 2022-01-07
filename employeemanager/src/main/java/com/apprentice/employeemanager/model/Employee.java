package com.apprentice.employeemanager.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String title;
    private String phone;
    @Column(nullable = false, updatable = false)
    private String employeeCode;
    private int pay;

    public Employee(String firstName, String lastName, String email, String title, String phone, int pay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.title = title;
        this.phone = phone;
        this.pay = pay;
    }
}
