package com.example.test.entity;

public class Employee {
    private int id;
    private String name;
    private String cardId;
    private int managerId;
    private int seniority;//工龄
    private int sex;
    private String position;
    private String headshot;
    private String phone;

    public Employee(int id, String name, String cardId, int managerId, int seniority, int sex, String position, String headshot, String phone) {
        this.id = id;
        this.name = name;
        this.cardId = cardId;
        this.managerId = managerId;
        this.seniority = seniority;
        this.sex = sex;
        this.position = position;
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
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cardId='" + cardId + '\'' +
                ", managerId=" + managerId +
                ", seniority=" + seniority +
                ", sex=" + sex +
                ", position='" + position + '\'' +
                ", headshot='" + headshot + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
