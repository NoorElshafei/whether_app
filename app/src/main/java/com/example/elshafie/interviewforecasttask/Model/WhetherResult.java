package com.example.elshafie.interviewforecasttask.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Elshafie on 11/17/2018.
 */
//class for the information of whether
public class WhetherResult implements Serializable {

    private Weather weather = new Weather();
    private String base;
    private Main main = new Main();
    private int visibility;
    private Wind wind = new Wind();
    private Clouds clouds;
    private int dt;
    private String dtforecast;
    private Sys sys = new Sys();
    private int id;
    private String name;
    private int cod;


    public WhetherResult() {

    }


    public String getDtforecast() {
        return dtforecast;
    }

    public void setDtforecast(String dtforecast) {
        this.dtforecast = dtforecast;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
