package com.garethabrahams.repository.impl;

import com.garethabrahams.factory.RaceFactory;
import com.garethabrahams.model.Race;
import com.garethabrahams.repository.RaceRepository;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceRepositoryImplTest {

    private static RaceRepository repository;
    private static Race race;
    private String raceID;

    @Test
    public void create() {
        repository = RaceRepositoryImpl.getRepository();
        race = RaceFactory.createRace("Coloured");
        Race result = repository.create(race);
        raceID = result.getId();
        Assert.assertEquals(raceID,race.getId());

    }

    @Test
    public void update() {
        create();
        Race result = repository.read(raceID);
        System.out.println(result.toString());

        String newRace = "Asian";
        Race newResult = new Race.Builder().copy(result).raceDesc(newRace).build();
        System.out.println(newResult.toString());
        repository.update(newResult);

        Assert.assertEquals(newRace,newResult.getRace());

    }

    @Test
    public void delete() {
        create();
        Race result = repository.read(raceID);
        System.out.println(result.toString());

        repository.delete(raceID);
        Race newResult = repository.read(raceID);
        Assert.assertNull(newResult);
    }

    @Test
    public void read() {
        create();
        Race result = repository.read(raceID);
        System.out.println(result.toString());
        Assert.assertEquals(raceID,result.getId());
    }
}