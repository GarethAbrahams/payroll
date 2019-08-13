package com.garethabrahams.Services.impl;

import com.garethabrahams.Services.EmployeeRaceService;
import com.garethabrahams.factory.EmployeeFactory;
import com.garethabrahams.factory.EmployeeRaceFactory;
import com.garethabrahams.factory.RaceFactory;
import com.garethabrahams.model.Employee;
import com.garethabrahams.model.EmployeeRace;
import com.garethabrahams.model.Race;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeRaceServiceImplTest {

    private static EmployeeRaceService service;
    private static EmployeeRace empRace;
    private String empID, raceID;

    @Test
    public void create() {
        service = EmployeeRaceServiceImpl.getEmployeeRaceService();
        Employee employee = EmployeeFactory.createEmployee("Gareth","Abrahams");
        Race race = RaceFactory.createRace("Coloured");
        empID = employee.getEmpNum();
        raceID = race.getId();

        empRace = EmployeeRaceFactory.createEmployeeRace(empID,raceID);
        EmployeeRace result = service.create(empRace);
        System.out.println(result.toString());
        Assert.assertEquals(empID,result.getEmpID());
    }

    @Test
    public void read() {
        create();
        EmployeeRace result = service.read(empID);

        Assert.assertEquals(empID,result.getEmpID());
    }

    @Test
    public void update() {
        create();
        EmployeeRace result = service.read(empID);
        Race newRace = RaceFactory.createRace("Black");

        EmployeeRace newResult = new EmployeeRace.Builder().copy(result).RaceID(newRace.getId()).build();
        System.out.println(newResult.toString());
        service.update(newResult);

        Assert.assertEquals(newRace.getId(),newResult.getRaceID());

    }

    @Test
    public void delete() {
        create();
        EmployeeRace result = service.read(empID);

        service.delete(empID);
        EmployeeRace newResult = service.read(empID);

        Assert.assertNull(newResult);
    }
}