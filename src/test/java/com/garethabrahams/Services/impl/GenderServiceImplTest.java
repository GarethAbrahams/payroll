package com.garethabrahams.Services.impl;

import com.garethabrahams.Services.GenderService;
import com.garethabrahams.factory.GenderFactory;
import com.garethabrahams.model.Gender;
import com.garethabrahams.repository.GenderRepository;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenderServiceImplTest {

    private static GenderService service;
    private static Gender gender;
    private String genderID;

    @Test
    public void create() {
        service = GenderServiceImpl.getGenderService();
        gender = GenderFactory.createGender("Male");
        genderID = gender.getId();

        Gender result = service.create(gender);
        Assert.assertEquals(result.getId(),genderID);

    }

    @Test
    public void read() {
        create();
        Gender result = service.read(genderID);
        Assert.assertEquals(result.getId(),genderID);
    }

    @Test
    public void update() {
        create();
        Gender result = service.read(genderID);
        System.out.println(result.toString());
        String newGender = "Female";

        Gender update = new Gender.Builder().copy(result).Gender(newGender).build();
        service.update(update);
        System.out.println(update.toString());

        Assert.assertEquals(newGender,update.getGender());

    }

    @Test
    public void delete() {
        create();
        Gender result = service.read(genderID);
        System.out.println(result.toString());

        service.delete(genderID);
        Gender newResult = service.read(genderID);

        Assert.assertNull(newResult);
    }
}