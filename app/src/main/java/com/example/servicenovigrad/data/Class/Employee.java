package com.example.servicenovigrad.data.Class;

public class Employee extends UserModel {
    private double hours = 0;
    private int emp_id = 0;
    private Branch branch;

    public Employee(String username, String password, String email) {
        super(username, password, email);
    }

    public Employee(String username, String password, String email, double hours, int emp_id, Branch branch) {
        super(username, password, email);
        this.hours = hours;
        this.emp_id = emp_id;
        this.branch = branch;
    }

    public Employee(double hours, int emp_id, Branch branch) {
        this.hours = hours;
        this.emp_id = emp_id;
        this.branch = branch;
    }

    // getter and setter
    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public Branch getBranch_id() {
        return branch;
    }

    public void setBranch_id(Branch branch_id) {
        this.branch = branch;
    }
}
