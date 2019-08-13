package com.garethabrahams.factory;

import com.garethabrahams.model.EmployeeGender;

public class EmployeeGenderFactory {

    public static EmployeeGender createEmployeeFactory(String empID, String genderID){
        return new EmployeeGender.Builder()
                .EmpID(empID)
                .GenderID(genderID)
                .build();
    }

}
