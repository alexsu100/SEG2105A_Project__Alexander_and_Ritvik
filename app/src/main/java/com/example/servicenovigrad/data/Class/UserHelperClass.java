package com.example.servicenovigrad.data.Class;

public class UserHelperClass {

    private boolean admin = false;
    private String email = "";
    private boolean employee = false;
    private String id = "";
    private String password = "";
    public String username = "";


    public UserHelperClass(boolean isAdmin, String email, boolean isEmployee, String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.admin = isAdmin;
        this.employee = isEmployee;
    }

    public UserHelperClass(String email, boolean isEmployee, String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.employee = isEmployee;
    }

    public UserHelperClass() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isEmployee() {
        return employee;
    }

    public void setEmployee(boolean employee) {
        this.employee = employee;
    }
}
