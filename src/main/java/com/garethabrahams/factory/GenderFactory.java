package com.garethabrahams.factory;

import com.garethabrahams.model.Gender;
import com.garethabrahams.util.IDGenerator;

public class GenderFactory {

        public static Gender createGender(String gender){
            String id = IDGenerator.generateID();
            return new Gender.Builder()
                    .id(id)
                    .Gender(gender)
                    .build();
        }
}
