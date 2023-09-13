package com.interswitch.payroll.exceptions;

import com.interswitch.payroll.model.SalaryRate;

public class SalaryRateNotFoundException extends RuntimeException{
    public SalaryRateNotFoundException(String message){
        super(message);
    }
}
