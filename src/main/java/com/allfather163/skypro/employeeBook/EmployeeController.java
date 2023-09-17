package com.allfather163.skypro.employeeBook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")

    public Employee addEmployee(@RequestParam String firstname, @RequestParam String lastname) {
        return employeeService.addEmployee(firstname, lastname);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstname, @RequestParam String lastname) {
        return employeeService.remoteEmployee(firstname, lastname);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstname, @RequestParam String lastname) {
        return employeeService.getEmployee(firstname, lastname);
    }

    @GetMapping()
    public Collection<Employee> getAll() {
        return employeeService.findAll();
    }
}