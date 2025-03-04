package com.example.test.entity;

import java.beans.Transient;

public class User {
    private int userid;
    private String username;//真实姓名
    private String password;
    private String headshot;//头像
    private String activationCode;//激活码
    private String phone;
    private String factory;//管理的厂房号
    private String name;//自己起的名字
    private int sex;

    public User(int userid, String username, String password, String headshot, String activationCode, String phone, String factory, String name, int sex) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.headshot = headshot;
        this.activationCode = activationCode;
        this.phone = phone;
        this.factory = factory;
        this.name = name;
        this.sex = sex;
    }


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", activationCode='" + activationCode + '\'' +
                ", headshot='" + headshot + '\'' +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                ", factory='" + factory + '\'' +
                '}';
    }

}
