package com.interswitch.payroll.service;

import com.interswitch.payroll.model.Department;

import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department updateDepartment(Department department, Long id);

}
