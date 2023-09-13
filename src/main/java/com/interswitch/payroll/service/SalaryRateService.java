package com.interswitch.payroll.service;

import com.interswitch.payroll.model.Employee;
import com.interswitch.payroll.model.SalaryRate;

import java.util.List;

public interface SalaryRateService {
    SalaryRate createSalary(SalaryRate salaryRate);
    SalaryRate updateSalary(SalaryRate salaryRate, Long id);
    List<SalaryRate> getAllSalaryRate();
    SalaryRate getSalaryById(Long id);
    List<Employee> getEmployeesBySalaryRate(Long id);

}
