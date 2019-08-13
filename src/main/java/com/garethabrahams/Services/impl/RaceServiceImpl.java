package com.garethabrahams.Services.impl;

import com.garethabrahams.Services.GenderService;
import com.garethabrahams.Services.RaceService;
import com.garethabrahams.model.Gender;
import com.garethabrahams.model.Race;
import com.garethabrahams.repository.GenderRepository;
import com.garethabrahams.repository.RaceRepository;
import com.garethabrahams.repository.impl.GenderRepositoryImpl;
import com.garethabrahams.repository.impl.RaceRepositoryImpl;

import java.util.Set;

public class RaceServiceImpl implements RaceService {

    private static RaceService service;
    private static RaceRepository repository;

    private RaceServiceImpl(){
        repository = RaceRepositoryImpl.getRepository();
    }

    public static RaceService getRaceService(){
        if (service == null)
            service = new RaceServiceImpl();
        return service;
    }

    @Override
    public Set<Race> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Race create(Race e) {
        return this.repository.create(e);
    }

    @Override
    public Race read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Race update(Race e) {
        return this.repository.update(e);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }
}
