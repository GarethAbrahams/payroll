package com.garethabrahams.Services.impl;

import com.garethabrahams.Services.EmployeeGenderService;
import com.garethabrahams.Services.EmployeeRaceService;
import com.garethabrahams.model.EmployeeGender;
import com.garethabrahams.model.EmployeeRace;
import com.garethabrahams.repository.EmployeeGenderRepository;
import com.garethabrahams.repository.EmployeeRaceRepository;
import com.garethabrahams.repository.impl.EmployeeGenderRepositoryImpl;
import com.garethabrahams.repository.impl.EmployeeRaceRepositoryImpl;

import java.util.Set;

public class EmployeeRaceServiceImpl implements EmployeeRaceService {

    private static EmployeeRaceService service = null;
    private EmployeeRaceRepository repository;

    private EmployeeRaceServiceImpl(){
        repository = EmployeeRaceRepositoryImpl.getRepository();
    }

    public static EmployeeRaceService getEmployeeRaceService(){
        if (service == null)
                service = new EmployeeRaceServiceImpl();
        return service;
    }

    @Override
    public EmployeeRace create(EmployeeRace e) {

        return this.repository.create(e);
    }

    @Override
    public EmployeeRace read(String s) {

        return this.repository.read(s);
    }

    @Override
    public EmployeeRace update(EmployeeRace e) {

        return this.repository.update(e);
    }

    @Override
    public void delete(String id) {
        this.repository.delete(id);
    }

    @Override
    public Set<EmployeeRace> getAll() {
        return repository.getAll();
    }
}
