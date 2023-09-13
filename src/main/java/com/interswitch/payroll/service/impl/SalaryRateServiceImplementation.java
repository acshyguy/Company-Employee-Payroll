package com.interswitch.payroll.service.impl;

import com.interswitch.payroll.exceptions.DepartmentNotFoundException;
import com.interswitch.payroll.exceptions.EmployeeCategoryNotFoundException;
import com.interswitch.payroll.exceptions.SalaryRateNotFoundException;
import com.interswitch.payroll.model.Department;
import com.interswitch.payroll.model.Employee;
import com.interswitch.payroll.model.SalaryRate;
import com.interswitch.payroll.repository.EmployeeRepository;
import com.interswitch.payroll.repository.SalaryRateRepository;
import com.interswitch.payroll.service.SalaryRateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryRateServiceImplementation implements SalaryRateService {

    private final SalaryRateRepository salaryRateRepository;
    private final EmployeeRepository employeeRepository;

    public SalaryRateServiceImplementation(SalaryRateRepository salaryRateRepository, EmployeeRepository employeeRepository) {
        this.salaryRateRepository = salaryRateRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public SalaryRate createSalary(SalaryRate salaryRate) {

        return salaryRateRepository.save(salaryRate);
    }

    @Override
    public SalaryRate updateSalary(SalaryRate salaryRate, Long id) {
        SalaryRate alreadyExistingSalaryRate = getSalaryById(id);
        if (alreadyExistingSalaryRate != null){
            salaryRateRepository.save(salaryRate);
        }
        throw new SalaryRateNotFoundException("SalaryRate with Id " + id + " not found!");
    }
    @Override
    public List<SalaryRate> getAllSalaryRate() {

        return salaryRateRepository.findAll();
    }

    @Override
    public SalaryRate getSalaryById(Long id) {
        return salaryRateRepository.findById(id)
                .orElseThrow(() -> new SalaryRateNotFoundException("Salary Rate with Id " + id + " not found!"));
    }
    @Override
    public List<Employee> getEmployeesBySalaryRate(Long id) {
        SalaryRate salaryRate = getSalaryById(id);
        if (salaryRate != null) {
            return employeeRepository.findByEmployeeCategoryId(salaryRate.getEmployeeCategoryId());
        }
        throw new SalaryRateNotFoundException("SalaryRate with ID " + id + " not found.");
    }



}
