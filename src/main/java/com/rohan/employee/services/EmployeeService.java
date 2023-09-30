package com.rohan.employee.services;

import org.springframework.stereotype.Service;

import com.rohan.employee.model.Employee;

import java.util.List;

@Service
public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(Long id);

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);
}
