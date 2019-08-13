package com.garethabrahams.repository.impl;

import com.garethabrahams.model.Race;
import com.garethabrahams.repository.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {

    private static RaceRepositoryImpl repository = null;
    private Set<Race> races;

    private RaceRepositoryImpl(){
        this.races = new HashSet<>();
    }

    public static RaceRepositoryImpl getRepository(){
        if (repository == null)
            repository = new RaceRepositoryImpl();

        return repository;
    }

    @Override
    public Set<Race> getAll() {
        return this.races;
    }

    @Override
    public Race create(Race race) {
        this.races.add(race);
        return race;
    }

    @Override
    public Race update(Race race) {
        Race oldRace = read(race.getId());
        if (oldRace!=null){
            Race newRace = new Race.Builder()
                    .copy(oldRace)
                    .build();

            return newRace;
        }
        return null;
    }

    @Override
    public void delete(String id) {
        this.races.remove(read(id));
    }

    @Override
    public Race read(String id) {
        for (Race race: this.races){
            if (race.getId().equals(id))
                return race;
        }
        return null;
    }
}
