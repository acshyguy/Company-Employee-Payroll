package com.interswitch.payroll.service;

import com.interswitch.payroll.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee, Long id);

}
