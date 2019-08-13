package com.garethabrahams.repository.impl;

import com.garethabrahams.factory.EmployeeFactory;
import com.garethabrahams.factory.GenderFactory;
import com.garethabrahams.model.Employee;
import com.garethabrahams.model.Gender;
import com.garethabrahams.repository.GenderRepository;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenderRepositoryImplTest {

    private static GenderRepository repository;
    private static Gender gender;
    private String genderID;

    @Test
    public void create() {
        repository = GenderRepositoryImpl.getRepository();
        gender = GenderFactory.createGender("Male");
        Gender result = repository.create(gender);
        genderID = result.getId();

        Assert.assertEquals(genderID,result.getId());
    }

    @Test
    public void update() {
        create();
        Gender gender = repository.read(genderID);
        System.out.println(gender.toString());

        String female = "Female";
        Gender updated = new Gender.Builder().copy(gender).Gender(female).build();
        System.out.println(updated.toString());
        this.repository.update(updated);
        Assert.assertSame(female,updated.getGender());
    }

    @Test
    public void delete() {
        create();
        Gender result = repository.read(genderID);
        System.out.println(result.toString());

        repository.delete(result.getId());
        Gender newResults = repository.read(genderID);
        Assert.assertNull(newResults);
    }

    @Test
    public void read() {
        create();
        Gender gender = repository.read(genderID);
        Assert.assertEquals("Male",gender.getGender());
    }
}