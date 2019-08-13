package com.garethabrahams.repository.impl;

import com.garethabrahams.factory.EmployeeFactory;
import com.garethabrahams.model.Employee;
import com.garethabrahams.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import sun.awt.geom.AreaOp;

import java.applet.Applet;

import static org.junit.Assert.*;

public class EmployeeRepositoryImplTest {

    private static EmployeeRepository repository;
    private static Employee employee;
    private String employeeID;

    @Test
    public void create() {
        repository = EmployeeRepositoryImpl.getRepository();

        employee = EmployeeFactory.createEmployee("Gareth","Abrahams");
        Employee results = repository.create(employee);
        employeeID = results.getEmpNum();
        Assert.assertEquals(employeeID,employee.getEmpNum());
    }

    @Test
    public void update() {
        create();
        Employee oldEmp = repository.read(employeeID);
        System.out.println(oldEmp.toString());

        String newLast = "Gates";
        Employee newEmp = new Employee.Builder().copy(oldEmp).lastName(newLast).build();
        System.out.println(newEmp.toString());

        this.repository.update(newEmp);
        Assert.assertEquals(newLast,newEmp.getLastName());

    }

    @Test
    public void delete() {
        create();
        Employee result = repository.read(employeeID);
        System.out.println(result.toString());

        repository.delete(employeeID);
        Employee newResult = repository.read(employeeID);

        Assert.assertNull(newResult);

    }

    @Test
    public void read() {
        create();
        Employee result = repository.read(employeeID);
        Assert.assertEquals(employeeID,result.getEmpNum());
    }
}