package com.garethabrahams.factory;

import com.garethabrahams.model.Race;
import com.garethabrahams.util.IDGenerator;

public class RaceFactory {

        public static Race createRace(String race){
            String id = IDGenerator.generateID();
            return new Race.Builder()
                    .idNum(id)
                    .raceDesc(race)
                    .build();
        }
}
