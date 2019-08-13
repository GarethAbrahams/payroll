package com.garethabrahams.model;

public class EmployeeRace {

    private String empID, raceID;

    public EmployeeRace(){ }

    public String getEmpID(){
        return empID;
    }

    public String getRaceID(){
        return raceID;
    }

    @Override
    public String toString() {
        return "EmployeeGender{" +
                "empID='" + empID + '\'' +
                ", genderID='" + raceID + '\'' +
                '}';
    }

    public EmployeeRace(Builder builder){
        this.empID = builder.empID;
        this.raceID = builder.raceID;
    }

    public static class Builder{
        private String empID,raceID;

        public Builder EmpID(String value){
            this.empID = value;
            return this;
        }

        public Builder RaceID(String value){
            this.raceID = value;
            return this;
        }

        public Builder copy(EmployeeRace empRace){
            this.raceID = empRace.raceID;
            this.empID = empRace.empID;
            return this;
        }

        public EmployeeRace build(){
            return new EmployeeRace(this);
        }
    }
}
