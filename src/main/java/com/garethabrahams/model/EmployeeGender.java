package com.garethabrahams.model;

import javafx.util.Builder;

import java.util.Locale;

public class EmployeeGender {

    private String empID, genderID;

    public EmployeeGender(){ }

    public String getEmpID(){
        return empID;
    }

    public String getGenderID(){
        return genderID;
    }

    @Override
    public String toString() {
        return "EmployeeGender{" +
                "empID='" + empID + '\'' +
                ", genderID='" + genderID + '\'' +
                '}';
    }

    public EmployeeGender (Builder builder){
        this.empID = builder.empID;
        this.genderID = builder.genderID;
    }

    public static class Builder{
        private String empID,genderID;

        public Builder EmpID(String value){
            this.empID = value;
            return this;
        }

        public Builder GenderID(String value){
            this.genderID = value;
            return this;
        }

        public Builder copy(EmployeeGender empGender){
            this.genderID = empGender.genderID;
            this.empID = empGender.empID;
            return this;
        }

        public EmployeeGender build(){
            return new EmployeeGender(this);
        }
    }
}
