package com.itexpert.springbootrest.service;

import com.itexpert.springbootrest.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> getEmployeeById(Long id);

    List<Employee> getAllEmployee();

    Employee updateEmployee(Long id, Employee employee);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(Long id);


}
