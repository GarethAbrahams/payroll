package com.garethabrahams.factory;

import com.garethabrahams.model.Race;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceFactoryTest {

    @Test
    public void createRace() {

        Race race = RaceFactory.createRace("Coloured");
        Assert.assertEquals("Coloured",race.getRace());
    }
}