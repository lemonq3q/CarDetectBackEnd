package com.example.test.entity;
//各个厂房的设备
public class Workshop_deviceId {
    private String workshop;
    private String deviceId;

    public Workshop_deviceId(String workshop, String deviceId) {
        this.workshop = workshop;
        this.deviceId = deviceId;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "Workshop_deviceId{" +
                "workshop='" + workshop + '\'' +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
