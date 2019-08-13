package com.garethabrahams.Services;

import com.garethabrahams.model.Employee;
import com.garethabrahams.model.Race;

import java.util.Set;

public interface RaceService extends iService<Race,String> {

        Set<Race> getAll();
}
