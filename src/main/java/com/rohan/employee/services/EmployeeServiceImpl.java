package com.rohan.employee.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.rohan.employee.entity.EmployeeEntity;
import com.rohan.employee.exception.EmployeeException;
import com.rohan.employee.model.Employee;
import com.rohan.employee.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    
    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        
        BeanUtils.copyProperties(employee, employeeEntity);
         
        if (employeeEntity.getEmailId()==null || employeeEntity.getEmailId()=="") {
			throw new EmployeeException("Enter mailId field");
		}
        else if (employeeEntity.getPassword()==null || employeeEntity.getPassword()=="") {
        	throw new EmployeeException("Enter password field");
		}
        else if (employeeEntity.getDepartment()==null || employeeEntity.getDepartment()=="") {
        	throw new EmployeeException("Enter department field");
		}
        else if (employeeEntity.getFirstName()==null || employeeEntity.getFirstName()=="") {
        	throw new EmployeeException("Enter firstName field");
		}
        else if (employeeEntity.getLastName()==null || employeeEntity.getLastName()=="") {
        	throw new EmployeeException("Enter lastName field");
		}
        else if (employeeEntity.getLocation()==null || employeeEntity.getLocation()=="") {
        	throw new EmployeeException("Enter location field");
		}
        else if (String.valueOf(employeeEntity.getSalary())==null) {
        	throw new EmployeeException("Enter salary field");
		}
        else if (String.valueOf(employeeEntity.getEmpId())==null) {
        	throw new EmployeeException("Enter empId field");
		}
        
        employeeRepository.save(employeeEntity);
        return employee;
    }

    
    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id)
        		.orElseThrow(() -> new EmployeeException("Record not found for id"+id));
        employeeRepository.delete(employee);
        return true;
    }

    
    @Override
    public Employee getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
        		.orElseThrow(() -> new EmployeeException("Record not found for id"+id));
       
//        if (employeeEntity==null) {
//			throw new EmployeeException("Employee not found in database");
//		}

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }


    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setEmpId(employee.getEmpId());
        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setDepartment(employee.getDepartment());
        employeeEntity.setSalary(employee.getSalary());
        employeeEntity.setLocation(employee.getLocation());
        employeeEntity.setPassword(employee.getPassword());

        employeeRepository.save(employeeEntity);
        return employee;
    }
    
    
    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities
                = employeeRepository.findAll();
        List<Employee> employees = employeeEntities
                .stream()
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getEmpId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId(),
                        emp.getPassword(),
                        emp.getDepartment(),
                        emp.getSalary(),
                        emp.getLocation()))
                .collect(Collectors.toList());
        return employees;
    }
}
