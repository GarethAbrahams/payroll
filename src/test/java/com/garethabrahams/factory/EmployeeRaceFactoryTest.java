package com.garethabrahams.factory;

import com.garethabrahams.model.Employee;
import com.garethabrahams.model.EmployeeGender;
import com.garethabrahams.model.EmployeeRace;
import com.garethabrahams.model.Race;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeRaceFactoryTest {

    @Test
    public void createEmployeeRace() {

        Employee employee = EmployeeFactory.createEmployee("Gareth","Abrahams");
        Race race = RaceFactory.createRace("Coloured");

        EmployeeRace empRace = EmployeeRaceFactory.createEmployeeRace(employee.getEmpNum(),race.getId());

        Assert.assertEquals(employee.getEmpNum(),empRace.getEmpID());
    }
}