package com.garethabrahams.Services;

import com.garethabrahams.model.EmployeeGender;
import com.garethabrahams.model.EmployeeRace;

import java.util.Set;

public interface EmployeeRaceService extends iService<EmployeeRace,String> {

        Set<EmployeeRace> getAll();
}
