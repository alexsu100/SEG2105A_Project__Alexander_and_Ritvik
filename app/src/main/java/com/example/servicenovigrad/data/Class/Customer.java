package com.example.servicenovigrad.data.Class;

public class Customer extends UserModel {
    private Address address = null;

    // constructor

    public Customer(String username, String password, String email) {
        super(username, password, email);
    }

    public Customer(String username, String password, String email, Address address) {
        super(username, password, email);
        this.address = address;
    }

    public Customer(Address address) {
        this.address = address;
    }

    // getter and setter
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
