package com.garethabrahams.factory;

import com.garethabrahams.model.EmployeeRace;

public class EmployeeRaceFactory {

    public static EmployeeRace createEmployeeRace(String empID, String raceID){
            return new EmployeeRace.Builder()
                    .EmpID(empID)
                    .RaceID(raceID)
                    .build();
    }
}
