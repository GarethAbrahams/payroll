package com.garethabrahams.repository.impl;

import com.garethabrahams.factory.EmployeeFactory;
import com.garethabrahams.factory.EmployeeGenderFactory;
import com.garethabrahams.factory.GenderFactory;
import com.garethabrahams.model.Employee;
import com.garethabrahams.model.EmployeeGender;
import com.garethabrahams.model.Gender;
import com.garethabrahams.repository.EmployeeGenderRepository;
import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeGenderRepositoryImplTest {

    private static EmployeeGenderRepository repository;
    private static EmployeeGender empGender;
    private String empID,genderID;


    @Test
    public void create() {
        repository = EmployeeGenderRepositoryImpl.getRepository();
        Employee employee = EmployeeFactory.createEmployee("Gareth","Abrahams");
        Gender gender = GenderFactory.createGender("Male");
        empID = gender.getId();
        genderID = employee.getEmpNum();

        empGender = EmployeeGenderFactory.createEmployeeFactory(empID,genderID);
        EmployeeGender result = repository.create(empGender);

        Assert.assertEquals(empID,result.getEmpID());
    }

    @Test
    public void update() {
        create();
        EmployeeGender result = repository.read(empID);
        System.out.println(result.toString());

        Gender newGender = GenderFactory.createGender("Female");

        EmployeeGender newResult = new EmployeeGender.Builder().copy(result).GenderID(newGender.getId()).build();
        System.out.println(newResult.toString());

        repository.update(newResult);

        Assert.assertEquals(newGender.getId(),newResult.getGenderID());
    }

    @Test
    public void delete() {
        create();
        EmployeeGender result = repository.read(empID);
        System.out.println(result.toString());

        repository.delete(empID);
        EmployeeGender newResult = repository.read(empID);

        Assert.assertNull(newResult);
    }

    @Test
    public void read() {
        create();
        EmployeeGender empGen = repository.read(empID);

        Assert.assertEquals(genderID,empGen.getGenderID());
    }
}