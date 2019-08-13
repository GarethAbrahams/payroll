package com.garethabrahams.repository.impl;

import com.garethabrahams.model.Employee;
import com.garethabrahams.model.EmployeeRace;
import com.garethabrahams.repository.EmployeeRaceRepository;
import com.garethabrahams.repository.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRaceRepositoryImpl implements EmployeeRaceRepository {

    private static EmployeeRaceRepositoryImpl repository = null;
    private Set<EmployeeRace> employeeRaces;

    private EmployeeRaceRepositoryImpl(){
        this.employeeRaces = new HashSet<>();
    }

    public static EmployeeRaceRepositoryImpl getRepository(){
        if (repository==null)
            repository = new EmployeeRaceRepositoryImpl();

        return repository;
    }


    @Override
    public Set<EmployeeRace> getAll() {
        return this.employeeRaces;
    }

    @Override
    public EmployeeRace create(EmployeeRace empRace) {
        this.employeeRaces.add(empRace);
        return empRace;
    }

    @Override
    public EmployeeRace update(EmployeeRace empRace) {
        EmployeeRace oldEmpRace = read(empRace.getEmpID());
        if (oldEmpRace != null){
            EmployeeRace newEmpRace = new EmployeeRace.Builder()
                    .copy(oldEmpRace)
                    .build();
            return newEmpRace;
        }
        return null;
    }

    @Override
    public void delete(String id) {
        this.employeeRaces.remove(read(id));
    }

    @Override
    public EmployeeRace read(String id) {
        for (EmployeeRace employeeRace : this.employeeRaces) {
            if (employeeRace.getEmpID().equals(id))
                return employeeRace;
        }
        return null;
    }
}
