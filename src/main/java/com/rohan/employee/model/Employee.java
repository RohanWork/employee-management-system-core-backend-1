package com.rohan.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private int empId;
    private String firstName;
    private String LastName;
    private String emailId;
    private String password;
    private String department;
    private BigDecimal salary;
    private String location;
}
