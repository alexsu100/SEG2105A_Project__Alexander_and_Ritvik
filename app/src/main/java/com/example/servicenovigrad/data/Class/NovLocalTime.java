package com.example.servicenovigrad.data.Class;

import java.time.LocalTime;

public class NovLocalTime{

    int hour;
    int minutes;

    public NovLocalTime(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public NovLocalTime() {
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
