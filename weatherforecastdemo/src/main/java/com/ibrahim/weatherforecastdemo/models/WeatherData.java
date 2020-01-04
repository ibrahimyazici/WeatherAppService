package com.ibrahim.weatherforecastdemo.models;

public class WeatherData {
    private String localtime;
    private int temperature;
    private boolean status;

    public WeatherData(String localtime, int temperature, boolean status) {
        this.localtime = localtime;
        this.temperature = temperature;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
