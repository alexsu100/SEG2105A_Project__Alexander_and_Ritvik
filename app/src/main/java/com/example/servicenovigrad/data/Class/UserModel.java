package com.example.servicenovigrad.data.Class;

public class UserModel {

    public String username;
    private String password;
    private String email;

    // constructors

    public UserModel(String username, String password, String email) {

        this.username = username;
        this.password = password;
        this.email = email;

    }

    public UserModel(){
    }

    // toString method, just put it here for now in case we need something


    // getters and setters

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


}