package com.example.test.entity;
//各个厂房的人数
public class WorkerNum {
    String workshop;
    int num;

    public WorkerNum(String workshop, int num) {
        this.workshop = workshop;
        this.num = num;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "WorkerNum{" +
                "workshop='" + workshop + '\'' +
                ", num=" + num +
                '}';
    }
}
