package com.garethabrahams.repository.impl;

import com.garethabrahams.factory.EmployeeFactory;
import com.garethabrahams.factory.EmployeeRaceFactory;
import com.garethabrahams.factory.RaceFactory;
import com.garethabrahams.model.Employee;
import com.garethabrahams.model.EmployeeRace;
import com.garethabrahams.model.Race;
import com.garethabrahams.repository.EmployeeRaceRepository;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeRaceRepositoryImplTest {

    private static EmployeeRaceRepository repository;
    private static EmployeeRace empRace;
    private String empID, raceID;

    @Test
    public void create() {
        repository = EmployeeRaceRepositoryImpl.getRepository();
        Employee employee = EmployeeFactory.createEmployee("Gareth","Abrahams");
        Race race = RaceFactory.createRace("Coloured");
        empID = employee.getEmpNum();
        raceID = race.getId();

        empRace = EmployeeRaceFactory.createEmployeeRace(empID,raceID);
        EmployeeRace result = repository.create(empRace);

        Assert.assertEquals(result.getEmpID(),empID);
    }

    @Test
    public void update() {
        create();
        EmployeeRace result = repository.read(empID);
        System.out.println(result.toString());

        Race newRace = RaceFactory.createRace("Indian");

        EmployeeRace newResult = new EmployeeRace.Builder().copy(result).RaceID(newRace.getId()).build();
        System.out.println(newResult.toString());

        Assert.assertEquals(newRace.getId(),newResult.getRaceID());
    }

    @Test
    public void delete() {
        create();
        EmployeeRace result = repository.read(empID);
        System.out.println(result.toString());

        repository.delete(empID);
        EmployeeRace newResult = repository.read(empID);

        Assert.assertNull(newResult);
    }

    @Test
    public void read() {
        create();
        EmployeeRace result = repository.read(empID);

        Assert.assertEquals(empID,result.getEmpID());
    }
}