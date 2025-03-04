package com.example.test.entity;

public class TemperatureData {
    public float temperature;
    public  long time;
    public String deviceId;//哪个设备发的温度信息

    public TemperatureData(float temperature,long time,String deviceId){
        this.temperature = temperature;
        this.time = time;
        this.deviceId = deviceId;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "TemperatureData{" +
                "temperature=" + temperature +
                ", time=" + time +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
