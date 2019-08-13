package com.garethabrahams.controller;

import com.garethabrahams.Services.*;
import com.garethabrahams.Services.impl.*;
import com.garethabrahams.factory.*;
import com.garethabrahams.model.*;

import java.util.Set;

public class EmployeeController {

    private EmployeeService employeeService = EmployeeServiceImpl.getEmployeeService();
    private RaceService raceService = RaceServiceImpl.getRaceService();
    private GenderService genderService = GenderServiceImpl.getGenderService();
    private EmployeeGenderService empGenService = EmployeeGenderServiceImpl.getEmployeeGenderService();
    private EmployeeRaceService empRaceService = EmployeeRaceServiceImpl.getEmployeeRaceService();;

    public Employee create(String fName, String lName, String gen, String rac){

        Employee employee = employeeService.create(EmployeeFactory.createEmployee(fName,lName));
        String empID = employee.getEmpNum();


        Gender gender = genderService.create(GenderFactory.createGender(gen));
        String genID = gender.getId();

        Race race = raceService.create(RaceFactory.createRace(rac));
        String raceID = race.getId();

        empGenService.create(EmployeeGenderFactory.createEmployeeFactory(empID,genID));
        empRaceService.create(EmployeeRaceFactory.createEmployeeRace(empID,raceID));

        return employee;
    }

    public String readEmp(String id){
        String genID = empGenService.read(id).getGenderID();
        String raceID = empRaceService.read(id).getRaceID();
        return (employeeService.read(id).toString()+" "+genderService.read(genID).getGender()+" "+raceService.read(raceID).getRace());
    }

}
