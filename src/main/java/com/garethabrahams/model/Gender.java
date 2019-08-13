package com.garethabrahams.model;

public class Gender {

    private String id,gender;

    public Gender(){   }

    public String getId(){
        return id;
    }

    public String getGender(){
        return gender;
    }

    public Gender (Builder builder){
        this.id = builder.id;
        this.gender = builder.gender;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static class Builder{
        private String id, gender;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder Gender(String value){
            this.gender = value;
            return this;
        }


        public Builder copy(Gender Gen){
            this.id = Gen.id;
            this.gender = Gen.gender;
            return this;
        }

        public Gender build(){
            return new Gender(this);
        }
    }
}
