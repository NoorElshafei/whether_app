package com.example.elshafie.interviewforecasttask.Model;

import java.text.DecimalFormat;

/**
 * Created by Elshafie on 11/17/2018.
 */

public class Main {
    private double temp;
    private int pressure;
    private int humidity;
    private double temp_min;
    private double temp_max;
    private int id1;

    public Main() {
    }

    public double getTemp() {

        return temp;
    }


    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public void setTemp(double temp) {
        this.temp = temp - 273.15;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }
}
