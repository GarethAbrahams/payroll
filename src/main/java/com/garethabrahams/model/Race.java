package com.garethabrahams.model;

public class Race {

    private String id,race;

    public Race(){}

    public String getId(){ return id; }

    public String getRace(){
        return race;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id='" + id + '\'' +
                ", race='" + race + '\'' +
                '}';
    }

    public Race (Builder builder){
        this.id = builder.id;
        this.race = builder.race;
    }

    public static class Builder{
        private String id, race;

        public Builder idNum(String value){
            this.id = value;
            return this;
        }

        public Builder raceDesc(String value){
            this.race = value;
            return this;
        }


        public Builder copy(Race R){
            this.id = R.id;
            this.race = R.race;
            return this;
        }

        public Race build(){
            return new Race(this);
        }
    }
}
