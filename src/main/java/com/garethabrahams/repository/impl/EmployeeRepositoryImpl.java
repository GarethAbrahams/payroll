package com.garethabrahams.repository.impl;

import com.garethabrahams.model.Employee;
import com.garethabrahams.repository.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static EmployeeRepositoryImpl repository = null;
    private Set<Employee> employees;

    private EmployeeRepositoryImpl(){
        this.employees = new HashSet<>();
    }

    public static EmployeeRepositoryImpl getRepository(){
        if (repository==null)
            repository = new EmployeeRepositoryImpl();

        return repository;
    }


    @Override
    public Set<Employee> getAll() {
        return this.employees;
    }

    @Override
    public Employee create(Employee emp) {
        this.employees.add(emp);
        return emp;
    }

    @Override
    public Employee update(Employee emp) {
        Employee oldEmp = read(emp.getEmpNum());
        if (oldEmp != null){
            Employee newEmp = new Employee.Builder()
                    .copy(oldEmp)
                    .build();
            return newEmp;
        }
        return null;
    }

    @Override
    public void delete(String id) {
        this.employees.remove(read(id));
    }

    @Override
    public Employee read(String id) {
        for (Employee employee : this.employees) {
            if (employee.getEmpNum().equals(id))
                return employee;
        }
        return null;
    }
}
