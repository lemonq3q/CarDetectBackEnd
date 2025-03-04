package com.example.test.entity;

public class NowHumidity {
    private String workshop;
    private long time;
    private float humidity;

    public NowHumidity(String workshop, long time, float humidity) {
        this.workshop = workshop;
        this.time = time;
        this.humidity = humidity;
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

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "NowHumidity{" +
                "workshop='" + workshop + '\'' +
                ", time=" + time +
                ", humidity=" + humidity +
                '}';
    }
}
