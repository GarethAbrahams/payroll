package com.garethabrahams.Services;

import com.garethabrahams.model.Gender;
import com.garethabrahams.model.Race;

import java.util.Set;

public interface GenderService extends iService<Gender,String> {

        Set<Gender> getAll();
}
