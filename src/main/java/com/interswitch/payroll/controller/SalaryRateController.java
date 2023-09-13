package com.interswitch.payroll.controller;

import com.interswitch.payroll.model.Employee;
import com.interswitch.payroll.model.EmployeeCategory;
import com.interswitch.payroll.model.SalaryRate;
import com.interswitch.payroll.service.SalaryRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salaryrates")
public class SalaryRateController {
    @Autowired
    private SalaryRateService salaryRateService;

    @PostMapping
    public ResponseEntity<SalaryRate> createSalaryRate(@RequestBody SalaryRate salaryRate){
        SalaryRate createdSalaryRate = salaryRateService.createSalary(salaryRate);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSalaryRate);
    }
    @PutMapping("/{id}")
    public ResponseEntity<SalaryRate> updateSalaryRate(@PathVariable Long id, @RequestBody SalaryRate salaryRate) {
        SalaryRate updatedSalary = salaryRateService.updateSalary(salaryRate, id);
        return ResponseEntity.ok(updatedSalary);
    }
    @GetMapping
    public ResponseEntity<List<SalaryRate>> getAllSalary() {
        List<SalaryRate> salaryRates = salaryRateService.getAllSalaryRate();
        return ResponseEntity.ok(salaryRates);
    }


    @GetMapping("/{id}/employees")
    public ResponseEntity<List<Employee>>getSalaryRateById(@PathVariable Long id) {
        List<Employee> salaryRate = salaryRateService.getEmployeesBySalaryRate(id);
        return ResponseEntity.ok(salaryRate);
    }

}
