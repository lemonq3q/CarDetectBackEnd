package com.example.test.entity;

public class Device {
    private String device_id;//设备ID
    private String workshop;//厂房号
    private String type;//
    private int state;//设备状态
    private long lastTime;//最后一次启动的时间
    private String description;

    public Device(String device_id, String workshop, String type, int state, long lastTime, String description) {
        this.device_id = device_id;
        this.workshop = workshop;
        this.type = type;
        this.state = state;
        this.lastTime = lastTime;
        this.description = description;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    //重写toString方法
    public String toString() {
        return "Device{" +
                "device_id='" + device_id + '\'' +
                ", workshop='" + workshop + '\'' +
                ", type='" + type + '\'' +
                ", state=" + state +
                ", lastTime=" + lastTime +
                ", description='" + description + '\'' +
                '}';
    }
}
