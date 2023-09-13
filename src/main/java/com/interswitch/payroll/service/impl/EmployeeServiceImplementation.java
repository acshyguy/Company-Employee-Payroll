package com.interswitch.payroll.service.impl;

import com.interswitch.payroll.exceptions.EmployeeNotFoundException;
import com.interswitch.payroll.model.Employee;
import com.interswitch.payroll.repository.EmployeeRepository;
import com.interswitch.payroll.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with Id " + id + "not found!"));
    }


    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee alreadyExistEmployee =getEmployeeById(id);
        if (alreadyExistEmployee != null){
            employeeRepository.save(employee);
        }
        throw new EmployeeNotFoundException("Employee with Id " + id + " not found!");
    }

}
