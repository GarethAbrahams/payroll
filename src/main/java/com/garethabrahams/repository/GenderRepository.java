package com.garethabrahams.repository;

import com.garethabrahams.model.Employee;
import com.garethabrahams.model.Gender;
import sun.plugin2.message.GetAppletMessage;

import java.util.Set;

public interface GenderRepository extends iRepository<Gender,String>{
    Set<Gender> getAll();
}
