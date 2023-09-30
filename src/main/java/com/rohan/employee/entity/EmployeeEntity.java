package com.rohan.employee.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "employee_table")
public class EmployeeEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
