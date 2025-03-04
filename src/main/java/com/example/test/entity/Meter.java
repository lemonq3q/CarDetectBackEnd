package com.example.test.entity;
//仪表盘
public class Meter {
    private String workshop;
    private int type;
    private long time;
    private String unit;//单位
    private float value;

    public Meter(String workshop, int type, long time, String unit, float value) {
        this.workshop = workshop;
        this.type = type;
        this.time = time;
        this.unit = unit;
        this.value = value;
    }


    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Meter{" +
                "workshop='" + workshop + '\'' +
                ", type=" + type +
                ", time=" + time +
                ", unit='" + unit + '\'' +
                ", value=" + value +
                '}';
    }
}
