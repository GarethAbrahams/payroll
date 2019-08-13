package com.garethabrahams.Services.impl;

import com.garethabrahams.Services.EmployeeService;
import com.garethabrahams.Services.GenderService;
import com.garethabrahams.model.Employee;
import com.garethabrahams.model.Gender;
import com.garethabrahams.repository.EmployeeRepository;
import com.garethabrahams.repository.GenderRepository;
import com.garethabrahams.repository.impl.EmployeeRepositoryImpl;
import com.garethabrahams.repository.impl.GenderRepositoryImpl;

import java.util.Set;

public class GenderServiceImpl implements GenderService {

    private static GenderService service;
    private static GenderRepository repository;

    private GenderServiceImpl(){
        repository = GenderRepositoryImpl.getRepository();
    }

    public static GenderService getGenderService(){
        if (service == null)
            service = new GenderServiceImpl();
        return service;
    }

    @Override
    public Set<Gender> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Gender create(Gender e) {
        return this.repository.create(e);
    }

    @Override
    public Gender read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Gender update(Gender e) {
        return this.repository.update(e);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }
}
