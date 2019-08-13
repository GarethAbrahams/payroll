package com.garethabrahams.Services.impl;

import com.garethabrahams.Services.EmployeeService;
import com.garethabrahams.factory.EmployeeFactory;
import com.garethabrahams.model.Employee;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeServiceImplTest {
    private static EmployeeService service;
    private static Employee employee;
    private String empID;
    @Test
    public void create() {
        service = EmployeeServiceImpl.getEmployeeService();
        employee = EmployeeFactory.createEmployee("Gareth","Abrahams");
        empID = employee.getEmpNum();
        Employee result = service.create(employee);

        Assert.assertEquals(empID,result.getEmpNum());
    }

    @Test
    public void read() {
        create();
        Employee result = service.read(empID);
        Assert.assertEquals(empID,result.getEmpNum());
    }

    @Test
    public void update() {
        create();
        Employee result = service.read(empID);
        String newLast = "Gates";
        Employee newResult = new Employee.Builder().copy(result).lastName(newLast).build();
        service.update(newResult);

        Assert.assertEquals(newLast,newResult.getLastName());
    }

    @Test
    public void delete() {
        create();
        Employee result = service.read(empID);
        System.out.println(result.toString());

        service.delete(empID);
        Employee newResult = service.read(empID);

        Assert.assertNull(newResult);

    }
}