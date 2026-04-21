package com.plurasight;

public class Employee {

    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    //constructors
    public Employee(){
        employeeId = 0;
        name ="";
        hoursWorked = 0.0;
        payRate = 0.0;
    }
    public Employee(int employeeId, String name, double hoursWorked, double payRate){
        this.employeeId =employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    //Methods
    public double getGrossPay(){
        return payRate * hoursWorked;
    }

    //Getters and Setters
    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
}
