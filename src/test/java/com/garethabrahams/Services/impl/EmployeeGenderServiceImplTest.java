package com.garethabrahams.Services.impl;

import com.garethabrahams.Services.EmployeeGenderService;
import com.garethabrahams.factory.EmployeeFactory;
import com.garethabrahams.factory.EmployeeGenderFactory;
import com.garethabrahams.factory.GenderFactory;
import com.garethabrahams.model.Employee;
import com.garethabrahams.model.EmployeeGender;
import com.garethabrahams.model.Gender;
import com.garethabrahams.repository.impl.EmployeeGenderRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeGenderServiceImplTest {

    private static EmployeeGenderService service;
    private static EmployeeGender empGender;
    private String empID,genderID;

    @Test
    public void create() {
        service = EmployeeGenderServiceImpl.getEmployeeGenderService();
        Employee employee = EmployeeFactory.createEmployee("Gareth","Abrahams");
        Gender gender = GenderFactory.createGender("Male");
        empID = employee.getEmpNum();
        genderID = gender.getId();

        empGender = EmployeeGenderFactory.createEmployeeFactory(empID,genderID);
        EmployeeGender result = service.create(empGender);
        System.out.println(empGender.toString());
        Assert.assertEquals(empID,result.getEmpID());
    }

    @Test
    public void read() {
        create();
        EmployeeGender result = service.read(empID);
        Assert.assertEquals(empID, result.getEmpID());
    }

    @Test
    public void update() {
        create();
        EmployeeGender result = service.read(empID);
        Gender newGender = GenderFactory.createGender("Female");

        EmployeeGender update = new EmployeeGender.Builder().copy(result).GenderID(newGender.getId()).build();
        System.out.println(update.toString());
        service.update(update);

        Assert.assertEquals(newGender.getId(),update.getGenderID());
    }

    @Test
    public void delete() {
        create();
        EmployeeGender result = service.read(empID);

        service.delete(empID);

        EmployeeGender newResult = service.read(empID);

        Assert.assertNull(newResult);
    }
}