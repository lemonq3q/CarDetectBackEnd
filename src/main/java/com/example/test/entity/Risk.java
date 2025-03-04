package com.example.test.entity;

import java.sql.Timestamp;

public class Risk {
    private int id;//风险ID用于标注风险事件
    private long time;
    private String picPath;//图片地址
    private String address;
    private String riskName;
    private String description;
    private int level;

    public Risk(int id, long time, String picPath, String address, String riskName, String description, int level) {
        this.id = id;
        this.time = time;
        this.picPath = picPath;
        this.address = address;
        this.riskName = riskName;
        this.description = description;
        this.level = level;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Risk{" +
                "id=" + id +
                ", time=" + time +
                ", picPath='" + picPath + '\'' +
                ", address='" + address + '\'' +
                ", riskName='" + riskName + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                '}';
    }
}
