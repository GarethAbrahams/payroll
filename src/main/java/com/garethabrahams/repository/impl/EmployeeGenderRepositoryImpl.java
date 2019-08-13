package com.garethabrahams.repository.impl;

import com.garethabrahams.model.EmployeeGender;
import com.garethabrahams.model.EmployeeRace;
import com.garethabrahams.repository.EmployeeGenderRepository;
import com.garethabrahams.repository.EmployeeRaceRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeGenderRepositoryImpl implements EmployeeGenderRepository {

    private static EmployeeGenderRepositoryImpl repository = null;
    private Set<EmployeeGender> employeeGenderSet;

    private EmployeeGenderRepositoryImpl(){
        this.employeeGenderSet = new HashSet<>();
    }

    public static EmployeeGenderRepositoryImpl getRepository(){
        if (repository==null)
            repository = new EmployeeGenderRepositoryImpl();

        return repository;
    }


    @Override
    public Set<EmployeeGender> getAll() {
        return this.employeeGenderSet;
    }

    @Override
    public EmployeeGender create(EmployeeGender empGender) {
        this.employeeGenderSet.add(empGender);
        return empGender;
    }

    @Override
    public EmployeeGender update(EmployeeGender empGender) {
        EmployeeGender oldEmpGender = read(empGender.getEmpID());
        if (oldEmpGender != null){
            EmployeeGender newEmpGender = new EmployeeGender.Builder()
                    .copy(oldEmpGender)
                    .build();
            return newEmpGender;
        }
        return null;
    }

    @Override
    public void delete(String id) {
        this.employeeGenderSet.remove(read(id));
    }

    @Override
    public EmployeeGender read(String id) {
        for (EmployeeGender employeeGender : this.employeeGenderSet) {
            if (employeeGender.getEmpID().equals(id))
                return employeeGender;
        }
        return null;
    }
}
