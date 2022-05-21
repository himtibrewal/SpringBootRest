package com.itexpert.springbootrest.service;

import com.itexpert.springbootrest.entity.Employee;
import com.itexpert.springbootrest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        return employeeRepository.findById(id)
                .map(employee1 -> {
                    employee1.setId(id);
                    employee1.setName(employee.getName());
                    employee1.setAddress(employee.getAddress());
                    employee1.setPhone(employee.getPhone());
                    return employeeRepository.save(employee1);
                }).orElseGet(() -> {
                    return employeeRepository.save(employee);
                });
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
