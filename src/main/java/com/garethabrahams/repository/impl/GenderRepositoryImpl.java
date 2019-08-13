package com.garethabrahams.repository.impl;

import com.garethabrahams.model.Gender;
import com.garethabrahams.model.Race;
import com.garethabrahams.repository.GenderRepository;
import com.garethabrahams.repository.RaceRepository;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {

    private static GenderRepositoryImpl repository = null;
    private Set<Gender> genders;

    private GenderRepositoryImpl(){
        this.genders = new HashSet<>();
    }

    public static GenderRepositoryImpl getRepository(){
        if (repository == null)
            repository = new GenderRepositoryImpl();

        return repository;
    }

    @Override
    public Set<Gender> getAll() {
        return this.genders;
    }

    @Override
    public Gender create(Gender gender) {
        this.genders.add(gender);
        return gender;
    }

    @Override
    public Gender update(Gender gender) {
        Gender oldgender = read(gender.getId());
        if (oldgender != null){
            Gender newGender = new Gender.Builder()
                    .copy(oldgender)
                    .build();

            return newGender;
        }
        return null;
    }

    @Override
    public void delete(String id) {
        this.genders.remove(read(id));
    }

    @Override
    public Gender read(String id) {
        for (Gender gender: this.genders){
            if (gender.getId().equals(id))
                return gender;
        }
        return null;
    }
}
