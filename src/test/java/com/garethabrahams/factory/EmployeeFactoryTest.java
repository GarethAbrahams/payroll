package com.garethabrahams.factory;

import com.garethabrahams.model.Employee;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeFactoryTest {

    @Test
    public void createEmployee() {

        Employee Gareth = EmployeeFactory.createEmployee("Gareth","Abrahams");

        System.out.println(Gareth.toString());

        Assert.assertEquals("Gareth",Gareth.getFirstName());


    }
}