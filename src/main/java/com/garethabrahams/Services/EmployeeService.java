package com.garethabrahams.Services;

import com.garethabrahams.model.Employee;

import java.util.Set;

public interface EmployeeService extends iService<Employee,String> {

        Set<Employee> getAll();
}
