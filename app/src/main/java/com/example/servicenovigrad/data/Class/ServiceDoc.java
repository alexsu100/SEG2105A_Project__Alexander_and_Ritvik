package com.example.servicenovigrad.data.Class;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ServiceDoc {

    String firstName;
    String lastName;
    String address;
    NovLocalDate birthday = new NovLocalDate(1800, 31, 1);

    public ServiceDoc(String firstName, String lastName, String address, NovLocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthday = birthday;
    }

    public ServiceDoc(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public NovLocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(NovLocalDate birthday) {
        this.birthday = birthday;
    }
}
