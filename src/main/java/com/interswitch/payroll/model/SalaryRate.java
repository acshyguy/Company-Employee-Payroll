package com.interswitch.payroll.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "salaryRate")

public class SalaryRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sal_Id", nullable = false)
    private Long id;
    @Column(name = "employeeCategory_Id", nullable = false)
    private Long employeeCategoryId;
    @Column(name = "level", nullable = false)
    private int level;
    @Column(name = "amount", nullable = false)
    private float amount;
}
