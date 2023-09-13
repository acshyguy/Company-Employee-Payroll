package com.interswitch.payroll.controller;

import com.interswitch.payroll.model.Employee;
import com.interswitch.payroll.model.EmployeeCategory;
import com.interswitch.payroll.service.EmployeeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeeCategories")
public class EmployeeCategoryController {

    @Autowired
    private EmployeeCategoryService employeeCategoryService;

    @PostMapping
    public ResponseEntity<EmployeeCategory> createEmployeeCategory(@RequestBody EmployeeCategory employeeCategory){
        EmployeeCategory createdEmployeeCategory = employeeCategoryService.createCategory(employeeCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployeeCategory);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeCategory> updateEmployeeCategory(@PathVariable Long id, @RequestBody EmployeeCategory employeeCategory) {
        EmployeeCategory updatedEmployeeCat = employeeCategoryService.updateEmployeeCat(employeeCategory, id);
        return ResponseEntity.ok(updatedEmployeeCat);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeCategory>> getAllEmployeeCategory() {
        List<EmployeeCategory> employeeCategories = employeeCategoryService.getAllEmployeeCategory();
        return ResponseEntity.ok(employeeCategories);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeCategory> getEmployeeCategoryById(@PathVariable Long id) {
        EmployeeCategory employeeCategory = employeeCategoryService.getEmployeeCategoryById(id);
        return ResponseEntity.ok(employeeCategory);
    }


}
