package com.interswitch.payroll.exceptions;

import com.interswitch.payroll.model.EmployeeCategory;

public class EmployeeCategoryNotFoundException extends RuntimeException{
    public EmployeeCategoryNotFoundException(String message){
        super(message);
    }
}
