package com.garethabrahams.Services;

import com.garethabrahams.model.Employee;
import com.garethabrahams.model.EmployeeGender;

import java.util.Set;

public interface EmployeeGenderService extends iService<EmployeeGender,String> {

        Set<EmployeeGender> getAll();
}
