package com.example.test.util;
//网页的各种状态码，如：200
//4 客户端的问题
//5 服务器
public class ResponseMessage {
    private int code;
    private String msg;
    private Object data;

    public ResponseMessage(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    //static：这意味着这个方法属于类本身，而不是类的实例。你可以在不创建类的实例的情况下调用它。
    //在其他类调用时，直接类名.方法名即可
    public static ResponseMessage success(String msg,Object data){
        return new ResponseMessage(200,msg,data);
    }

    public static ResponseMessage error(String msg,Object data){
        return new ResponseMessage(400,msg,data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
