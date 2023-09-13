package com.interswitch.payroll.controller;

import com.interswitch.payroll.model.Department;
import com.interswitch.payroll.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        System.out.println(department.getDescription());
        Department createdDepartment = departmentService.createDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);
//        return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
      }
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department){
        Department updatedDepartment = departmentService.updateDepartment(department, id);
        return ResponseEntity.ok(updatedDepartment);
    }


    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        Department department = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }



}
