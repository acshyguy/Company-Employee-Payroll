package com.interswitch.payroll.service.impl;

import com.interswitch.payroll.exceptions.EmployeeCategoryNotFoundException;
import com.interswitch.payroll.exceptions.EmployeeNotFoundException;
import com.interswitch.payroll.model.EmployeeCategory;
import com.interswitch.payroll.repository.EmployeeCategoryRepository;
import com.interswitch.payroll.service.EmployeeCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeCategoryServiceImplementation implements EmployeeCategoryService {

    private final EmployeeCategoryRepository employeeCategoryRepository;

    public EmployeeCategoryServiceImplementation(EmployeeCategoryRepository employeeCategoryRepository) {
        this.employeeCategoryRepository = employeeCategoryRepository;
    }

    @Override
    public EmployeeCategory createCategory(EmployeeCategory employeeCategory) {
        return employeeCategoryRepository.save(employeeCategory);
    }

    @Override
    public List<EmployeeCategory> getAllEmployeeCategory() {
        return employeeCategoryRepository.findAll();
    }

    @Override
    public EmployeeCategory getEmployeeCategoryById(Long id) {
        return employeeCategoryRepository.findById(id)
                .orElseThrow(() -> new EmployeeCategoryNotFoundException("Employee Category with Id " + id + " not found!"));
    }

    @Override
    public EmployeeCategory updateEmployeeCat(EmployeeCategory employeeCategory, Long id) {
        EmployeeCategory alreadyExistingEmployeeCategory = getEmployeeCategoryById(id);
        if (alreadyExistingEmployeeCategory != null){
            employeeCategoryRepository.save(employeeCategory);
        }
        throw new EmployeeCategoryNotFoundException("Employee Category with Id " + id + " not found!");
    }
}
