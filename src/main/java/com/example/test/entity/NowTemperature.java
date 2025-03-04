package com.example.test.entity;

public class NowTemperature {
    private String workshop;
    private long time;
    private float temperature;

    public NowTemperature(String workshop, long time, float temperature) {
        this.workshop = workshop;
        this.time = time;
        this.temperature = temperature;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "NowTemperature{" +
                "workshop='" + workshop + '\'' +
                ", time=" + time +
                ", temperature=" + temperature +
                '}';
    }
}
