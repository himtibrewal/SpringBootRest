package com.example.springbootrest.service;

import com.example.springbootrest.model.Employee;
import jdk.nashorn.internal.ir.EmptyNode;

import java.util.List;

public interface EmployeeService {

    public Employee getEmployeeById(Integer id);

    public List<Employee> getAllEmployee();

    public Employee saveEmployee(Employee employee);

    public void deleteEmployee(Integer id);


}
