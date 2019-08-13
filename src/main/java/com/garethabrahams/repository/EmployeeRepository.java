package com.garethabrahams.repository;

import com.garethabrahams.model.Employee;

import java.util.Set;

public interface EmployeeRepository extends iRepository<Employee,String>{
    Set<Employee> getAll();
}
