package com.allfather163.skypro.employeeBook;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private List<Employee> employees;
    private static final int EMPLOYEE_SIZE = 3;
    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }
    @Override
    public Employee addEmployee(String firstname, String lastname) {
        if (employees.size() == EMPLOYEE_SIZE) {
            throw new EmployeeStorageIsFullException();
        }

        Employee employee = new Employee(firstname, lastname);

        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }
    @Override
    public Employee remoteEmployee(String firstname, String lastname) {
        Employee employee = new Employee(firstname, lastname);


        if (!employees.remove(employee)) {
            throw new NotFoundException();
        }
        return employee;
    }
    @Override
    public Employee getEmployee(String firstname, String lastname) {
        Employee employee = new Employee(firstname, lastname);
        if (!employees.contains(employee)) {
            throw new NotFoundException();
        }
        return employee;
    }
    @Override
    public Collection<Employee> findAll() {
        return employees;
    }
}