package com.example.test.entity;

import java.sql.Timestamp;

public class Attendance {
    private String cardId;//ID卡
    private Timestamp time;//时间
    private int isAttendance;//标注时间类型 来是0，走是1
    private String note;//备注

    //构造函数
    public Attendance(String cardId, Timestamp time, int isAttendance, String note) {
        this.cardId = cardId;
        this.time = time;
        this.isAttendance = isAttendance;
        this.note = note;
    }


    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getIsAttendance() {
        return isAttendance;
    }

    public void setIsAttendance(int isAttendance) {
        this.isAttendance = isAttendance;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "cardId='" + cardId + '\'' +
                ", time=" + time +
                ", isAttendance=" + isAttendance +
                ", note='" + note + '\'' +
                '}';
    }
}
