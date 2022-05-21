package com.example.springbootrest.service;

import com.example.springbootrest.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public Employee getEmployeeById(Integer id) {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Himanshu");
        e1.setAddress("Bangalore");
        return e1;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List list = new ArrayList<Employee>();
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Himanshu");
        e1.setAddress("Bangalore");

        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("Jyoti");
        e2.setAddress("Bangalore");
        list.add(e1);
        list.add(e2);
        return list;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Himanshu");
        e1.setAddress("Bangalore");
        return e1;
    }

    @Override
    public void deleteEmployee(Integer id) {

    }
}
