package com.garethabrahams.Services.impl;

import com.garethabrahams.Services.EmployeeGenderService;
import com.garethabrahams.Services.EmployeeService;
import com.garethabrahams.model.Employee;
import com.garethabrahams.model.EmployeeGender;
import com.garethabrahams.repository.EmployeeGenderRepository;
import com.garethabrahams.repository.EmployeeRepository;
import com.garethabrahams.repository.impl.EmployeeGenderRepositoryImpl;
import com.garethabrahams.repository.impl.EmployeeRepositoryImpl;

import java.util.Set;

public class EmployeeGenderServiceImpl implements EmployeeGenderService {

    private static EmployeeGenderService service = null;
    private EmployeeGenderRepository repository;

    private EmployeeGenderServiceImpl(){
        repository = EmployeeGenderRepositoryImpl.getRepository();
    }

    public static EmployeeGenderService getEmployeeGenderService(){
        if (service == null)
                service = new EmployeeGenderServiceImpl();
        return service;
    }

    @Override
    public EmployeeGender create(EmployeeGender e) {

        return this.repository.create(e);
    }

    @Override
    public EmployeeGender read(String s) {

        return this.repository.read(s);
    }

    @Override
    public EmployeeGender update(EmployeeGender e) {

        return this.repository.update(e);
    }

    @Override
    public void delete(String id) {
        this.repository.delete(id);
    }

    @Override
    public Set<EmployeeGender> getAll() {
        return repository.getAll();
    }
}
