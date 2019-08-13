package com.garethabrahams.controller;

import com.garethabrahams.Services.*;
import com.garethabrahams.Services.impl.*;
import com.garethabrahams.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeControllerTest {
    EmployeeController employeeController;
    private Employee employee;
    private String empID;

    @Before
    public void create() {
        employeeController = new EmployeeController();
        employee = employeeController.create("Gareth","Abrahams","Male","Coloured");
        empID = employee.getEmpNum();
        Assert.assertNotNull(employee);

    }

    @Test
    public void readEmp() {
        String result = employeeController.readEmp(empID);
        System.out.println(result);
    }
}