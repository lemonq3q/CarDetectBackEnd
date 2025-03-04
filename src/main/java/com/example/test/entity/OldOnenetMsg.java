package com.example.test.entity;

public class OldOnenetMsg {
    private int type; //设备消息类型
    private int dev_id; //设备id
    private String ds_id; //数据流名称
    private long at; //时间戳
    private String value;  //数据值
    private int status;  //设备上下线标识
    private int login_type;  //设备登陆协议类型

    public OldOnenetMsg(int type, int dev_id, String ds_id, long at, String value, int status, int login_type) {
        this.type = type;
        this.dev_id = dev_id;
        this.ds_id = ds_id;
        this.at = at;
        this.value = value;
        this.status = status;
        this.login_type = login_type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDev_id() {
        return dev_id;
    }

    public void setDev_id(int dev_id) {
        this.dev_id = dev_id;
    }

    public String getDs_id() {
        return ds_id;
    }

    public void setDs_id(String ds_id) {
        this.ds_id = ds_id;
    }

    public long getAt() {
        return at;
    }

    public void setAt(long at) {
        this.at = at;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLogin_type() {
        return login_type;
    }

    public void setLogin_type(int login_type) {
        this.login_type = login_type;
    }

    @Override
    public String toString() {
        return "OldOnenetMsg{" +
                "type=" + type +
                ", dev_id=" + dev_id +
                ", ds_id=" + ds_id +
                ", at=" + at +
                ", value='" + value + '\'' +
                ", status=" + status +
                ", login_type=" + login_type +
                '}';
    }
}
