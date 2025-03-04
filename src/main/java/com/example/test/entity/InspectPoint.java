package com.example.test.entity;

public class InspectPoint {
    private String workshop;
    private int seq;
    private String point;

    public InspectPoint(String workshop, int seq, String point) {
        this.workshop = workshop;
        this.seq = seq;
        this.point = point;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "InspectionPoint{" +
                "workshop='" + workshop + '\'' +
                ", seq=" + seq +
                ", point='" + point + '\'' +
                '}';
    }
}

