package com.example.test.entity;

import java.sql.Timestamp;

public class Employee_attendance {
    private int id;
    private String name;
    private String cardId;
    private int managerId;
    private int seniority;//工龄
    private int sex;
    private String position;
    private Timestamp time;
    private Integer isAttendance;
    private String note;
    private String headshot;//头像
    private String phone;

    public Employee_attendance(int id, String name, String cardId, int managerId, int seniority, int sex,
                               String position, Timestamp time, Integer isAttendance, String note, String
                                       headshot, String phone) {
        this.id = id;
        this.name = name;
        this.cardId = cardId;
        this.managerId = managerId;
        this.seniority = seniority;
        this.sex = sex;
        this.position = position;
        this.time = time;
        this.isAttendance = isAttendance;
        this.note = note;
        this.headshot = headshot;
        this.phone = phone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getIsAttendance() {
        return isAttendance;
    }

    public void setIsAttendance(Integer isAttendance) {
        this.isAttendance = isAttendance;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee_attendance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cardId='" + cardId + '\'' +
                ", managerId=" + managerId +
                ", seniority=" + seniority +
                ", sex=" + sex +
                ", position='" + position + '\'' +
                ", time=" + time +
                ", isAttendance=" + isAttendance +
                ", note='" + note + '\'' +
                ", headshot='" + headshot + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
