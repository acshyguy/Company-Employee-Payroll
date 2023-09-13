package com.interswitch.payroll.repository;

import com.interswitch.payroll.model.EmployeeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCategoryRepository extends JpaRepository<EmployeeCategory, Long> {

}
