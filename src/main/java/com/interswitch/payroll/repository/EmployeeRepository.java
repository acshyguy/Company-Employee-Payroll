package com.interswitch.payroll.repository;

import com.interswitch.payroll.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmployeeCategoryId(Long employeeCategoryId);

}
