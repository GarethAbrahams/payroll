package com.garethabrahams.repository;

import com.garethabrahams.model.EmployeeGender;
import com.garethabrahams.model.EmployeeRace;

import java.util.Set;

public interface EmployeeGenderRepository extends iRepository<EmployeeGender,String>{
    Set<EmployeeGender> getAll();
}
