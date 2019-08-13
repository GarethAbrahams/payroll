package com.garethabrahams.Services.impl;

import com.garethabrahams.Services.RaceService;
import com.garethabrahams.factory.RaceFactory;
import com.garethabrahams.model.Race;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceServiceImplTest {
    private static RaceService service;
    private static Race race;
    private String raceID;

    @Test
    public void create() {
        service = RaceServiceImpl.getRaceService();
        race = RaceFactory.createRace("Coloured");
        raceID = race.getId();
        Race result = service.create(race);

        Assert.assertEquals(raceID,result.getId());
    }

    @Test
    public void read() {
        create();
        Race result = service.read(raceID);
        Assert.assertEquals(result.getId(),raceID);
    }

    @Test
    public void update() {
        create();
        Race result = service.read(raceID);
        System.out.println(result.toString());

        String newRace="white";

        Race newResult = new Race.Builder().copy(result).raceDesc(newRace).build();
        service.update(newResult);
        System.out.println(newResult.toString());

        Assert.assertEquals(newRace,newResult.getRace());

    }

    @Test
    public void delete() {
        create();
        Race result = service.read(raceID);
        System.out.println(result.toString());

        service.delete(raceID);
        Race newResult = service.read(raceID);

        Assert.assertNull(newResult);
    }
}