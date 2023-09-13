package com.interswitch.payroll.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "employee")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_Id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "dateOfBirth", nullable = false)
    private LocalDateTime dateOfBirth;
    @Column(name = "joinedDate", nullable = false)
    private LocalDateTime joinedDated;
    @Column(name = "dept_Id", nullable = false)
    private Long departmentId;
    @Column(name = "empCat_Id", nullable = false)
    private Long employeeCategory;

//    @OneToOne(mappedBy = "managerId", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Department department;
}
