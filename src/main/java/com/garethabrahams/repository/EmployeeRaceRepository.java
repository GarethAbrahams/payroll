package com.garethabrahams.repository;

import com.garethabrahams.model.EmployeeRace;
import com.garethabrahams.model.Race;

import java.util.Set;

public interface EmployeeRaceRepository extends iRepository<EmployeeRace,String>{
    Set<EmployeeRace> getAll();
}
