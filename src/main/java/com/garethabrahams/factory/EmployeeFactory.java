package com.garethabrahams.factory;

import com.garethabrahams.model.Employee;
import com.garethabrahams.util.IDGenerator;

public class EmployeeFactory {

    public static Employee createEmployee(String firstName, String lastName){
                String empID = IDGenerator.generateID();

                return new Employee.Builder()
                        .empNum(empID)
                        .firstName(firstName)
                        .lastName(lastName)
                        .build();
    }
}
