package com.interswitch.payroll.service.impl;

import com.interswitch.payroll.exceptions.DepartmentNotFoundException;
import com.interswitch.payroll.exceptions.EmployeeCategoryNotFoundException;
import com.interswitch.payroll.model.Department;
import com.interswitch.payroll.model.EmployeeCategory;
import com.interswitch.payroll.repository.DepartmentRepository;
import com.interswitch.payroll.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImplementation(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department, Long id) {
        Department alreadyExistingDepartment = getDepartmentById(id);
        if (alreadyExistingDepartment != null){
            return departmentRepository.save(department);
        }
        else {
            throw new DepartmentNotFoundException("Department with Id " + id + " not fo und!");
        }
    }
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department with Id " + id + " not found!"));
    }



}
