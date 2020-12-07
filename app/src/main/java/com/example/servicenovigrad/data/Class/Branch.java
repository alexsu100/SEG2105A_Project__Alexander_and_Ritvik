package com.example.servicenovigrad.data.Class;

import android.os.Build;


import java.time.LocalTime;

public class Branch {

    Address address;
    NovLocalTime startTime = new NovLocalTime(9, 00);
    NovLocalTime endTime = new NovLocalTime(17, 30);

    public Branch(Address address, NovLocalTime startTime, NovLocalTime endTime) {
        this.address = address;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Branch(){
    }

    public Branch(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public NovLocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(NovLocalTime startTime) {
        this.startTime = startTime;
    }

    public NovLocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(NovLocalTime endTime) {
        this.endTime = endTime;
    }
}
