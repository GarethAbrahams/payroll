package com.garethabrahams.Services.impl;

import com.garethabrahams.Services.EmployeeService;
import com.garethabrahams.model.Employee;
import com.garethabrahams.repository.EmployeeRepository;
import com.garethabrahams.repository.impl.EmployeeRepositoryImpl;

import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeService service = null;
    private EmployeeRepository repository;

    private EmployeeServiceImpl(){
        repository = EmployeeRepositoryImpl.getRepository();
    }

    public static EmployeeService getEmployeeService(){
        if (service == null)
                service = new EmployeeServiceImpl();
        return service;
    }

    @Override
    public Employee create(Employee e) {

        return this.repository.create(e);
    }

    @Override
    public Employee read(String s) {

        return this.repository.read(s);
    }

    @Override
    public Employee update(Employee e) {

        return this.repository.update(e);
    }

    @Override
    public void delete(String id) {
        this.repository.delete(id);
    }

    @Override
    public Set<Employee> getAll() {
        return repository.getAll();
    }
}
