package com.example.test.entity;


public class UserCenter {

    private int userid;
    private String username;
    private String password;
    private String headshot;
    private String phone;
    private String factory;
    private String name;
    private Integer sex;
    private String useraddress;
    private Integer managerid;

    private Integer employee;
    private Integer device;
    private Integer model;
    private Integer risk;
    private Integer inspect;


    public UserCenter(int userid, String username, String password, String headshot, String phone, String factory, String name, Integer sex, String useraddress, Integer managerid, Integer employee, Integer device, Integer model, Integer risk, Integer inspect) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.headshot = headshot;
        this.phone = phone;
        this.factory = factory;
        this.name = name;
        this.sex = sex;
        this.useraddress = useraddress;
        this.managerid = managerid;
        this.employee = employee;
        this.device = device;
        this.model = model;
        this.risk = risk;
        this.inspect = inspect;
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

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public Integer getEmployee() {
        return employee;
    }

    public void setEmployee(Integer employee) {
        this.employee = employee;
    }

    public Integer getDevice() {
        return device;
    }

    public void setDevice(Integer device) {
        this.device = device;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public Integer getRisk() {
        return risk;
    }

    public void setRisk(Integer risk) {
        this.risk = risk;
    }

    public Integer getInspect() {
        return inspect;
    }

    public void setInspect(Integer inspect) {
        this.inspect = inspect;
    }

    @Override
    public String toString() {
        return "UserCenter{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", headshot='" + headshot + '\'' +
                ", phone='" + phone + '\'' +
                ", factory='" + factory + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", useraddress='" + useraddress + '\'' +
                ", managerid=" + managerid +
                ", employee=" + employee +
                ", device=" + device +
                ", model=" + model +
                ", risk=" + risk +
                ", inspect=" + inspect +
                '}';
    }
}
