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
@Table(name = "employeeCategory")

public class EmployeeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empCat_Id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "description", nullable = false, length = 500)
    private String description;
}
