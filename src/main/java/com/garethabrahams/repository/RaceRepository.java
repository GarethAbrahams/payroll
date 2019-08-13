package com.garethabrahams.repository;

import com.garethabrahams.model.Gender;
import com.garethabrahams.model.Race;

import java.util.Set;

public interface RaceRepository extends iRepository<Race,String>{
    Set<Race> getAll();
}
