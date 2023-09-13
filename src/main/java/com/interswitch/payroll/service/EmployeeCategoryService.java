package com.interswitch.payroll.service;

import com.interswitch.payroll.model.Department;
import com.interswitch.payroll.model.EmployeeCategory;

import java.util.List;

public interface EmployeeCategoryService {
    EmployeeCategory createCategory(EmployeeCategory employeeCategory);
    List<EmployeeCategory> getAllEmployeeCategory();
    EmployeeCategory getEmployeeCategoryById(Long id);
    EmployeeCategory updateEmployeeCat(EmployeeCategory employeeCategory, Long id);

}
