package com.example.test.entity;

public class DeviceModel {
    private String device_id;
    private int model_id;

    public DeviceModel(String device_id, int model_id) {
        this.device_id = device_id;
        this.model_id = model_id;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    @Override
    public String toString() {
        return "DeviceModel{" +
                "device_id='" + device_id + '\'' +
                ", model_id=" + model_id +
                '}';
    }
}
