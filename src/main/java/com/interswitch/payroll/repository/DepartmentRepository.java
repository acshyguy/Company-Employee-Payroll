package com.interswitch.payroll.repository;

import com.interswitch.payroll.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
