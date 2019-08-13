package com.garethabrahams.model;

public class Employee {

    private String empNum, firstName, lastName;

    public Employee() {  }

    public String getEmpNum() {
        return empNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "empNum='" + empNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Employee (Builder builder){
        this.empNum = builder.empNum;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public static class Builder{
        private String empNum, firstName, lastName;

        public Builder empNum(String value){
            this.empNum = value;
            return this;
        }

        public Builder firstName(String value){
            this.firstName = value;
            return this;
        }

        public Builder lastName(String value){
            this.lastName = value;
            return this;
        }

        public Builder copy(Employee emp){
            this.firstName = emp.firstName;
            this.lastName = emp.lastName;
            this.empNum = emp.empNum;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
